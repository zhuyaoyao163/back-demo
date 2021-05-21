package com.example.backdemo.demo.okhttp;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

/**
 * @description:
 * @author: superman
 * @create: 2020-07-15 10:55
 **/
public class Demo1 {

    private static final String URL = "http://route.showapi.com/105-31";

    public static void test1() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("showapi_appid", "292291")
                .add("showapi_sign", "c7220e0769c34df78e76969f9229d7bd")
                .add("fromCode", "EUR")
                .add("toCode", "CNY")
                .add("money", "1")
                .build();
//        Map<String, Object> paramMap = Maps.newHashMap();
//        paramMap.put("showapi_appid", "292291");
//        paramMap.put("showapi_sign", "c7220e0769c34df78e76969f9229d7bd");
//        paramMap.put("fromCode", "EUR");
//        paramMap.put("toCode", "CNY");
//        paramMap.put("money", "100");
//        RequestBody requestBody = RequestBody.create(JSON.toJSONBytes(paramMap), MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"));

        Request request = new Request.Builder()
                .url(URL)
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.code());
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                System.out.println(JSON.toJSONString(call));
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
////                System.out.println(JSON.toJSONString(call));
//                System.out.println(response.body().string());
//                response.close();
//            }
//        });
    }

    public static void main(String[] args) {
        test1();
        System.out.println(123123);
    }
}
