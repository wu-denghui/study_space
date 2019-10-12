package com.goodhealth.framework.filter;

import com.goodhealth.comm.util.StringUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * xss过滤器
 */
public class XssRequestWrapper extends HttpServletRequestWrapper {

    /**
     * 判断是否是上传 上传忽略
     */
    private boolean isUpData = false;

    public XssRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
        String contentType = servletRequest.getContentType();
        if (null != contentType) {
            isUpData = contentType.startsWith("multipart");
        }
    }

    /**
     *
     * The default behavior of this method is to call getAttribute(String name)
     * on the wrapped request object.
     */
    @Override
    public Object getAttribute(String name) {
        Object value = super.getAttribute(name);
        if (value instanceof String) {
            value = XssFilterBusiness.filter(String.valueOf(value));
        }
        return value;
    }

    /**
     * The default behavior of this method is to return getParameter(String
     * name) on the wrapped request object.
     */
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (value != null) {
            value = XssFilterBusiness.filter(value);
        }
        return value;
    }

    /**
     * The default behavior of this method is to return getParameterMap() on the
     * wrapped request object.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Map getParameterMap() {
        Map paramMap = super.getParameterMap();

        for (Iterator iterator = paramMap.entrySet().iterator(); iterator
                .hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String[] values = (String[]) entry.getValue();
            for (int i = 0; i < values.length; i++) {
                values[i] = XssFilterBusiness.filter(values[i]);
            }
            if(StringUtil.isNotNull(values)) {
                entry.setValue(values);
            }
        }
        return paramMap;
    }

    /**
     * The default behavior of this method is to return
     * getParameterValues(String name) on the wrapped request object.
     */
    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                values[i] = XssFilterBusiness.filter(values[i]);
            }
        }
        return values;
    }

    /**
     * getInputStream()方法的流处理，注解方式获取数据貌似是根据这个流取得的数据。因为super.getInputStream()
     * 流只允许读取一次，所以在getInputStream()方法中处理完流数据后返回了一个新的ServletInputStream
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (isUpData) {
            return super.getInputStream();
        } else {

            final ByteArrayInputStream bais = new ByteArrayInputStream(
                    inputHandlers(super.getInputStream()).getBytes("UTF-8"));

            return new ServletInputStream() {

                @Override
                public int read() throws IOException {
                    return bais.read();
                }

                @Override
                public boolean isFinished() {
                    return false;
                }

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setReadListener(ReadListener readListener) {
                }
            };
        }

    }

    /**
     * 请求数据读取
     * @param servletInputStream
     * @return
     */
    public String inputHandlers(ServletInputStream servletInputStream) {
        String line = "";
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = servletInputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            line = result.toString("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (servletInputStream != null) {
                try {
                    servletInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(result!=null){
                try {
                    result.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return XssFilterBusiness.filter(line);
    }
}

