package com.creation.core.config;

import com.creation.core.utils.AppProperty;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Deprecated
@Configuration
public class ApacheHttpClient {

    @Bean
    public HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }

    @Bean
    @Lazy
    public HttpGet httpGet() {
        return new HttpGet(
                AppProperty.getProperty("restful.get.url").toString());
    }

    @Bean
    @Lazy
    public HttpPost httpPost() {
        return new HttpPost(
                AppProperty.getProperty("restful.post.url").toString());
    }


}
