package com.creation.core.controller.service;

import com.creation.core.utils.AppProperty;
import com.creation.core.utils.xml.PropertyApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public abstract class RestService extends Rest {

    Logger logger = Logger.getLogger(Rest.class.getName());

    private String jsonInput;

    public void configure() {

    }

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


    public String getResponseInfo() {
        return jsonInput;
    }

    public void postProcess() {

    }
}
