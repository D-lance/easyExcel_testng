package com.demo.utils;

import io.restassured.response.Response;

import java.util.Map;

import static com.demo.function.TokenCache.reqBuild;

/**
 * Created by dingxinhui on 2019-07-19.
 */
public class HttpsRequest {

    // rest-assured get请求
    public static Response getSend(String url, Map params){

        if(params == null){
            Response response = reqBuild()
                    .get(url+url)
                    .prettyPeek();
            return response;}
        else {
            Response response = reqBuild()
                    .params(params)
                    .get(url+url)
                    .prettyPeek();
            return response;}
    }


    // rest-assured post请求
    public static Response postSend(String url,String body){

        Response response = reqBuild()
                .body(body)
                .post(url+url)
                .prettyPeek();


        return response;

    }
}
