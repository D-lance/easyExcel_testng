package com.demo.utils;

import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by dingxinhui on 2019-07-16.
 */

// 封装断言
public class Assertion {

    public static void Assertion(String result, Response response){

        if ("0".equals(result)) {
            /***
             * {"rc": 0}*/

            response.then().body("status", equalTo(200));

        }
        else if("1".equals(result)){
            /***
             *
             * */
            response.then().body("status", equalTo(400));

        }
        else {
            response.then().body("status", equalTo(10000));
        }
    }
}
