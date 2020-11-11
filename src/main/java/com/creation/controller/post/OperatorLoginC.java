package com.creation.controller.post;

import com.creation.core.controller.post.AuthorizationPostController;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;
@Deprecated
@Component
public class OperatorLoginC extends AuthorizationPostController {

    @Override
    public void setHttpPost() {
        httpPost = new HttpPost("http://api.mskpropusk.com/operators/login");
    }

    @Override
    public void setRequest(List<Object> reqObjects) {
        try {
            output = new StringEntity("{\n" +
                    "    \"credentials\": {\n" +
                    "        \"email\": \"operator@test.ru\",\n" +
                    "        \"password\": \"12345678\"\n" +
                    "    }\n" +
                    "}");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void configure() {

    }

   /* @Bean(name = "UserEntity")
    @Lazy
    public User getUser() {
        Auth o = parser.fromJson(getResponseInfo(), Auth.class);
        return o.getUser();
    }*/
}
