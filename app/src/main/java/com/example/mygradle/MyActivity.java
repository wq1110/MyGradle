package com.example.mygradle;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Joyce.wang on 2024/6/27 18:00
 *
 * @Description TODO
 */
public class MyActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void synchronous_Request_Get() {
        OkHttpClient client = new OkHttpClient();

        Request getRequest = new Request.Builder()
                .url("https://mytodoserver.com/todolist")
                .build();

        client.newCall(getRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }

    public void asynchronous_Request_Get() {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder queryUrlBuilder = HttpUrl.get("https://mytodoserver.com/todolist").newBuilder();
        queryUrlBuilder.addQueryParameter("filter", "done");

        Request request = new Request.Builder()
                .url(queryUrlBuilder.build())
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void asynchronous_Request_Param_Get() {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder queryUrlBuilder = HttpUrl.get("https://mytodoserver.com/todolist").newBuilder();
        queryUrlBuilder.addQueryParameter("filter", "done");

        Request request = new Request.Builder()
                .url(queryUrlBuilder.build())
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
