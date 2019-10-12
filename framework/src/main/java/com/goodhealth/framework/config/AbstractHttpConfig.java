package com.goodhealth.framework.config;

import com.goodhealth.comm.constant.GlobalConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.RestAdapter;
import retrofit.client.Request;
import retrofit.client.UrlConnectionClient;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * @Description
 * @Author WDH
 * @Date 2019/9/23 9:23
 **/
public abstract class AbstractHttpConfig implements RestAdapter.Log {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 构建builder
     *
     * @param connectTimeout    超时时间（连接）
     * @param readTimeout       超时时间（读取）
     * @return
     */
    protected RestAdapter getBuilder(String httpHost, int connectTimeout, int readTimeout, RestAdapter.LogLevel logLevel){
        return new RestAdapter.Builder()
                .setClient(new EcoUrlConnectionClient(connectTimeout, readTimeout))
                .setLogLevel(logLevel)
                .setEndpoint(httpHost)
                .setLog(this)
                .build();
    }

    /**
     * 构建builder
     *
     * @param connectTimeout    超时时间（连接）
     * @param readTimeout       超时时间（读取）
     * @return
     */
    protected RestAdapter getBuilder(String httpHost, int connectTimeout, int readTimeout){
        return this.getBuilder(httpHost, connectTimeout, readTimeout, RestAdapter.LogLevel.FULL);
    }

    /**
     * 构建builder(默认超时时间3s)
     * @return
     */
    protected RestAdapter getBuilder(String httpHost){
        return this.getBuilder(httpHost, GlobalConstants.HTTP_CONNECT_TIMEOUT_DEFAULT, GlobalConstants.HTTP_READ_TIMEOUT_DEFAULT);
    }


    /**
     * log
     *
     * @param message
     */
    @Override
    public void log(String message) {
        logger.info(message);
    }

    /**
     * 官网rest调用客户端
     */
    class EcoUrlConnectionClient extends UrlConnectionClient {

        private int connectTimeout;
        private int readTimeout;

        EcoUrlConnectionClient(int connectTimeout, int readTimeout){
            this.connectTimeout = connectTimeout;
            this.readTimeout = readTimeout;
        }

        @Override
        protected HttpURLConnection openConnection(Request request) throws IOException {
            HttpURLConnection connection = super.openConnection(request);
            connection.setConnectTimeout(this.connectTimeout);
            connection.setReadTimeout(this.readTimeout);
            return connection;
        }
    }

}
