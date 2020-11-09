package com.creation.controllers.post;

import com.creation.controllers.core.post.SimplePostController;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class OperatorLoginC extends SimplePostController {
    @Override
    public void setHttpPost() {
        httpPost = new HttpPost("http://api.mskpropusk.com/operators/login");
    }

    @Override
    public void setRequest() {
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
}
