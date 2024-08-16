package com.example.myapplication.location.http;

import com.example.myapplication.location.util.LogHelper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpManager {

    private static final String URL_BASE = "http://mynameislicheng.free.idcfengye.com";

    public static void get(String data) {
//        String url = "https://www.baidu.com";
        String url = String.format("%s?address=%s", URL_BASE, data);
        getBase(url, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                // 处理响应体
                String responseBody = response.body().string();
                LogHelper.log(responseBody);
            }
        });

    }

    private static void getBase(String url, final okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }
}
