package com.creation.controllers.core.get;

import com.creation.controllers.core.RestService;
import com.creation.core.utils.AppProperty;
import com.creation.core.utils.xml.PropertyApp;
import org.apache.http.client.methods.HttpGet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public abstract class GetService extends RestService {

    private final Logger logger = Logger.getLogger(GetService.class.getName());
    protected HttpGet httpGet = null;
    private String jsonInput;

    public abstract void setHttpGet();

    public void read() {
        StringBuilder completeString = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            while ((output = br.readLine()) != null) {
                completeString.append(output);
            }
            if (Boolean.parseBoolean(AppProperty.getProperty(PropertyApp.DEV_TRACE))) {
                logger.info("Output from Server ....");
                logger.info(completeString.toString());
            }
        } catch (IOException exc) {
            logger.info(exc.getMessage());
        }
        jsonInput = completeString.toString();
    }

    public void configure() {
        httpGet.addHeader("accept", "application/json");
    }

    public void getResponse() {
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
        } catch (IOException | RuntimeException exc) {
            logger.info(exc.getMessage());
        }
    }

    public String getResponseInfo() {
        return jsonInput;
    }
}
