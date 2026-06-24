package com.systemdesign.lld.observerpattern.features.weatherstation.observers;

import com.systemdesign.lld.observerpattern.core.weatherstation.Observable;
import com.systemdesign.lld.observerpattern.core.weatherstation.Observer;

public class ForecastDisplay implements Observer {
    private final Observable weatherObservable;

    public ForecastDisplay(Observable weatherObservable) {
        this.weatherObservable = weatherObservable;
    }

    @Override
    public void update() {
        System.out.println("Updating weather data to do some analytics : " + weatherObservable.toString());
        display();
    }

    public void display() {
        System.out.println("Forecast Details: Displaying information about Rain, Temperature Trends, Significant Weather Events and other phenomemnon...");
    }
}
