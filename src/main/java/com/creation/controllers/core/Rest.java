package com.creation.controllers.core;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Rest {

    @Autowired
    protected HttpClient httpClient;

    protected HttpResponse response;

    protected Gson parser = new Gson();
}
