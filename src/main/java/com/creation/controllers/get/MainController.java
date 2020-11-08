package com.creation.controllers.get;

import com.creation.controllers.core.get.GetObjectController;
import com.creation.core.utils.AppProperty;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
