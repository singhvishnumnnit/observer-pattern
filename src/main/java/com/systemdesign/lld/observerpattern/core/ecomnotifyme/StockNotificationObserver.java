package com.systemdesign.lld.observerpattern.core.ecomnotifyme;

public interface StockNotificationObserver {
    void update();

    String getNotificationMethod();
    String getUserId();


}
