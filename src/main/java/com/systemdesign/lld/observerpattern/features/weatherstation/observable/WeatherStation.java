package com.systemdesign.lld.observerpattern.features.weatherstation.observable;

import com.systemdesign.lld.observerpattern.core.weatherstation.Observable;
import com.systemdesign.lld.observerpattern.core.weatherstation.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {
    private List<Observer> observers;
    private float humidity;
    private float temp;
    private float pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        System.out.println("[+] Observer registered: " + observer.getClass().getSimpleName());
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("[-] Observer removed: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            System.out.println("Notifying observer : " + observer.getClass().getSimpleName());
            observer.update();
        }
    }

    @Override
    public void setWeatherReadings(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemp() {
        return temp;
    }

    public float getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return "WeatherStation{" +
                ", humidity=" + humidity +
                ", temp=" + temp +
                ", pressure=" + pressure +
                '}';
    }
}
