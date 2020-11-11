package com.creation.core.controller.service;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.springframework.stereotype.Component;

@Component
public abstract class Rest {

    //@Autowired
    protected HttpClient httpClient;

    protected HttpResponse response;

    protected Gson parser = new Gson();
}
