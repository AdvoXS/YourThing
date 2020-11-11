package com.creation.controller.post;

import com.creation.core.controller.post.SimplePostController;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.util.List;
@Deprecated
public class UserSignUpC extends SimplePostController {
    @Override
    public void setHttpPost() {
        httpPost = new HttpPost("http://api.mskpropusk.com/users/sign_up");
    }

    @Override
    public void setRequest(List<Object> reqObjects) {
        try {
            output = new StringEntity("{\n" +
                    "        \"email\": \"vasya@gmail.ru\"\n" +
                    "}");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override

    public void configure() {

    }
}
