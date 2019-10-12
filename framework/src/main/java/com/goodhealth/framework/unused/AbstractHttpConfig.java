///*
// * Copyright by Deppon and the original author or authors.
// *
// * This document only allow internal use ,Any of your behaviors using the file
// * not internal will pay legal responsibility.
// *
// * You may learn more information about Deppon from
// *
// *
// *      http://www.deppon.com
// *
// */
//package config;
//
//import com.deppon.dpboot.framework.logging.Logger;
//import com.deppon.dpboot.framework.logging.LoggerFactory;
//import com.deppon.eco.base.constant.GlobalConstants;
//import retrofit.RestAdapter;
//import retrofit.client.Request;
//import retrofit.client.UrlConnectionClient;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//
///**
// * ：RestAdapter配置基类
// * @author yadongcui
// * @date 2019-08-08 15:55
// */
//public abstract class AbstractHttpConfig implements RestAdapter.Log {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    /**
//     * 构建builder
//     *
//     * @param connectTimeout    超时时间（连接）
//     * @param readTimeout       超时时间（读取）
//     * @return
//     */
//    protected RestAdapter getBuilder(String httpHost, int connectTimeout, int readTimeout, RestAdapter.LogLevel logLevel){
//        return new RestAdapter.Builder()
//                .setClient(new EcoUrlConnectionClient(connectTimeout, readTimeout))
//                .setLogLevel(logLevel)
//                .setEndpoint(httpHost)
//                .setLog(this)
//                .build();
//    }
//
//    /**
//     * 构建builder
//     *
//     * @param connectTimeout    超时时间（连接）
//     * @param readTimeout       超时时间（读取）
//     * @return
//     */
//    protected RestAdapter getBuilder(String httpHost, int connectTimeout, int readTimeout){
//        return this.getBuilder(httpHost, connectTimeout, readTimeout, RestAdapter.LogLevel.FULL);
//    }
//
//    /**
//     * 构建builder(默认超时时间3s)
//     * @return
//     */
//    protected RestAdapter getBuilder(String httpHost){
//        return this.getBuilder(httpHost, GlobalConstants.HTTP_CONNECT_TIMEOUT_DEFAULT, GlobalConstants.HTTP_READ_TIMEOUT_DEFAULT);
//    }
//
//
//    /**
//     * log
//     *
//     * @param message
//     */
//    @Override
//    public void log(String message) {
//        logger.info(message);
//    }
//
//    /**
//     * 官网rest调用客户端
//     */
//    class EcoUrlConnectionClient extends UrlConnectionClient{
//
//        private int connectTimeout;
//        private int readTimeout;
//
//        EcoUrlConnectionClient(int connectTimeout, int readTimeout){
//            this.connectTimeout = connectTimeout;
//            this.readTimeout = readTimeout;
//        }
//
//        @Override
//        protected HttpURLConnection openConnection(Request request) throws IOException {
//            HttpURLConnection connection = super.openConnection(request);
//            connection.setConnectTimeout(this.connectTimeout);
//            connection.setReadTimeout(this.readTimeout);
//            return connection;
//        }
//    }
//
//}
