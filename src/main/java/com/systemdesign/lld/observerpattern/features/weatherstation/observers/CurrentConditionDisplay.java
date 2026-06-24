package com.systemdesign.lld.observerpattern.features.weatherstation.observers;

import com.systemdesign.lld.observerpattern.core.weatherstation.Observable;
import com.systemdesign.lld.observerpattern.core.weatherstation.Observer;

public class CurrentConditionDisplay implements Observer {
    private final Observable observable;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Updating weather data...");
        display();
    }

    public void display() {
        System.out.println("Current weather conditions : " + observable.toString());
    }
}
