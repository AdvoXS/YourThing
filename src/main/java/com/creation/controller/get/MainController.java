package com.creation.controller.get;

import com.creation.core.controller.get.GetObjectController;
import com.creation.core.utils.AppProperty;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Deprecated
@Component
public class MainController extends GetObjectController {

    @Override
    public void createObjects() {
        MainPage mainPage = parser.fromJson(getResponseInfo(), MainPage.class);
        objectList.add(parser.fromJson(getResponseInfo(), MainPage.class));
    }

    @Override
    public void setHttpGet() {
        httpGet = new HttpGet(AppProperty.getProperty("restful.get.url"));
    }

    @Override
    public void configure() {

    }

    static public class MainPage {
        boolean alive;
        LocalDateTime timeStamp;
        boolean dbAlive;

        public MainPage(boolean alive, LocalDateTime timeStamp, boolean dbAlive) {
            this.alive = alive;
            this.timeStamp = timeStamp;
            this.dbAlive = dbAlive;
        }
    }
}
