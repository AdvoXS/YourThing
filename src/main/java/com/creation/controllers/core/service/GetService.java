package com.creation.controllers.core.service;

import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.logging.Logger;

public abstract class GetService extends RestService {

    private final Logger logger = Logger.getLogger(GetService.class.getName());
    protected HttpGet httpGet = null;

    public abstract void setHttpGet();

    public void getResponse() {
        try {
            if (httpGet != null) {
                response = httpClient.execute(httpGet);
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getStatusLine().getStatusCode());
                }
            }
        } catch (IOException | RuntimeException exc) {
            logger.info(exc.getMessage());
        }
    }

}
