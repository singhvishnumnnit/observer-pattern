package com.systemdesign.lld.observerpattern;

import com.systemdesign.lld.observerpattern.core.ecomnotifyme.StockAvailabilityObservable;
import com.systemdesign.lld.observerpattern.core.ecomnotifyme.StockNotificationObserver;
import com.systemdesign.lld.observerpattern.features.ecomnotifyme.observable.IphoneProductObservable;
import com.systemdesign.lld.observerpattern.features.ecomnotifyme.observers.EmailNotificationObserver;
import com.systemdesign.lld.observerpattern.features.ecomnotifyme.observers.PushNotificationObserver;

public class ECommerceStockNotificationRunner {
    public static void main(String[] args) {
        System.out.println("--------- Ecommerce Stock Availability Notification ---------");
        // Create an iPhone product - stock available = 10 units
        StockAvailabilityObservable iphoneProduct = new IphoneProductObservable("IP15", "iPhone 15", 55000.0, 10);
        // Create observers
        StockNotificationObserver emailNotificationObserver = new EmailNotificationObserver("vishnu123", "vishnu10jnv@gmail.com");
        StockNotificationObserver pushNotificationObserver = new PushNotificationObserver("xyz111", "jnv@gmail.com");
        // Mansoon Sale - Purchase all 10 units
        iphoneProduct.purchase(10);
        // Stock unavailability leads to users subscribing to notifications
        boolean success = iphoneProduct.purchase(1); // -> Failed purchase
        // Register observers - subscribe for notifications upon stock availability
        if (!success) {
            iphoneProduct.addStockObserver(emailNotificationObserver);
            iphoneProduct.addStockObserver(pushNotificationObserver);
        }

        iphoneProduct.restock(10);

        iphoneProduct.removeStockObserver(emailNotificationObserver);

        // Users purchase upon receiving notifications
        iphoneProduct.purchase(1); // purchases 1 unit
        iphoneProduct.purchase(1); // purchases 1 unit

        // NYE Sale - All 18 units sold
        iphoneProduct.purchase(18);
        iphoneProduct.purchase(1); // purchases 1 unit
    }
}
