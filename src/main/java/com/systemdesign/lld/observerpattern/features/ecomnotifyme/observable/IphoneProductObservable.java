package com.systemdesign.lld.observerpattern.features.ecomnotifyme.observable;

import com.systemdesign.lld.observerpattern.core.ecomnotifyme.StockAvailabilityObservable;
import com.systemdesign.lld.observerpattern.core.ecomnotifyme.StockNotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneProductObservable implements StockAvailabilityObservable {
    private final String productId;
    private final String productName;
    private final double price;

    private final List<StockNotificationObserver> stockNotificationObservers;
    private int stockQuantity;

    public IphoneProductObservable(String productId, String productName, double price, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockNotificationObservers = new ArrayList<>();
        this.stockQuantity = stockQuantity;
    }

    @Override
    public void addStockObserver(StockNotificationObserver stockNotificationObserver) {
        stockNotificationObservers.add(stockNotificationObserver);
        System.out.println("[+] " + stockNotificationObserver.getUserId() + " subscribed for notification on " + productName);
    }

    @Override
    public void removeStockObserver(StockNotificationObserver stockNotificationObserver) {
        stockNotificationObservers.remove(stockNotificationObserver);
        System.out.println("[-] " + stockNotificationObserver.getUserId() + " unsubscribed for notification on " + productName);
    }

    @Override
    public void notifyStockObservers() {
        if(stockQuantity > 0 && !stockNotificationObservers.isEmpty()) {
            System.out.println("Notifying " + stockNotificationObservers.size() + " subscribers....");
            // Create a copy to avoid concurrent modification
            List<StockNotificationObserver> observersToNotify = new ArrayList<>(stockNotificationObservers);

            for (StockNotificationObserver stockNotificationObserver : observersToNotify) {
                stockNotificationObserver.update();
            }
        }
    }

    @Override
    public void restock(int quantity) {
        boolean wasOutOfStock = stockQuantity == 0;
        stockQuantity += stockQuantity + quantity;
        System.out.println("RESTOCKED: " + productName + " - Added " + quantity + " items " + " | Current Stock : " + stockQuantity);
        // Only notify if product was previously out of stock
        if(stockQuantity > 0 && wasOutOfStock) {
            notifyStockObservers();
        }
    }

    @Override
    public boolean purchase(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            System.out.println("PURCHASE SUCCESS: " + quantity + " units of " + productName + " | " + "Remaining stock: " + stockQuantity);
            return true;
        } else {
            System.out.println("PURCHASE FAILED: " + productName + " is out of stock! | " + "Available Quantity: " + stockQuantity);
            return false;
        }
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
