package com.systemdesign.lld.observerpattern.features.weatherstation.observers;

import com.systemdesign.lld.observerpattern.core.weatherstation.Observable;
import com.systemdesign.lld.observerpattern.core.weatherstation.Observer;

public class PhoneDisplayObserver implements Observer {
    private final Observable weatherObservable;

    public PhoneDisplayObserver(Observable weatherObservable) {
        this.weatherObservable = weatherObservable;
    }

    @Override
    public void update() {
        System.out.println("Updating weather data to display on PhoneDisplay.");
        display();
    }

    public void display() {
        System.out.println("Phone Display Details : " + weatherObservable.toString());
    }
}
