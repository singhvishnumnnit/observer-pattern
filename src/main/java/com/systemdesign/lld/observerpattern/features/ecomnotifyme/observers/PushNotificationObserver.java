package com.systemdesign.lld.observerpattern.features.ecomnotifyme.observers;

import com.systemdesign.lld.observerpattern.core.ecomnotifyme.StockNotificationObserver;

public class PushNotificationObserver implements StockNotificationObserver {
    private final String userid;
    private final String deviceToken;

    public PushNotificationObserver(String userid, String deviceToken) {
        this.userid = userid;
        this.deviceToken = deviceToken;
    }

    @Override
    public void update() {
        sendPushNotification();
    }

    private void sendPushNotification() {
        System.out.println("PUSH NOTIFICATION SENT to: " + deviceToken + " - " + "Product is back in stock! Hurry Up!!");
    }

    @Override
    public String getNotificationMethod() {
        return "Push Notification";
    }

    @Override
    public String getUserId() {
        return userid;
    }
}
