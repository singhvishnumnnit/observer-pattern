package com.systemdesign.lld.observerpattern.core;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
    void setWeatherReadings(float temp, float humidity, float pressure);
}
