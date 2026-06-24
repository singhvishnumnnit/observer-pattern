package com.systemdesign.lld.observerpattern.features.ecomnotifyme.observers;

import com.systemdesign.lld.observerpattern.core.ecomnotifyme.StockNotificationObserver;

public class EmailNotificationObserver implements StockNotificationObserver {
    private final String userId;
    private final String emailAddress;

    public EmailNotificationObserver(String userId, String emailAddress) {
        this.userId = userId;
        this.emailAddress = emailAddress;
    }

    @Override
    public void update() {
        sendEmail();
    }

    private void sendEmail() {
        System.out.println("Email sent to : " + emailAddress + " - " + " Product is back into stock! Hurry UP!!!");
    }

    @Override
    public String getNotificationMethod() {
        return "Email";
    }

    @Override
    public String getUserId() {
        return userId;
    }
}
