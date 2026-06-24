package com.systemdesign.lld.observerpattern.core.ecomnotifyme;

public interface StockAvailabilityObservable {
    void addStockObserver(StockNotificationObserver stockNotificationObserver);

    void removeStockObserver(StockNotificationObserver stockNotificationObserver);

    void notifyStockObservers();

    boolean purchase(int quantity);

    void restock(int quantity);
}
