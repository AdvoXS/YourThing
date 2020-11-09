package com.creation.controllers.core.post;

import com.creation.controllers.core.RestService;
import com.creation.controllers.core.get.GetService;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.logging.Logger;

public abstract class PostService extends RestService {

    private final Logger logger = Logger.getLogger(GetService.class.getName());
    protected HttpPost httpPost = null;
    protected StringEntity output = null;
    private String jsonInput;

    public abstract void setHttpPost();

    public abstract void setRequest();

    public void setContentType() {
        if (output != null)
            output.setContentType("application/json");
    }

    public void send() {
        if (httpPost != null && output != null) {
            httpPost.setEntity(output);
            try {
                response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getStatusLine().getStatusCode());
                }
            } catch (IOException | RuntimeException exc) {
                logger.info(exc.getMessage());
            }
        }
    }
}
