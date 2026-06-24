package com.systemdesign.lld.observerpattern;

import com.systemdesign.lld.observerpattern.core.weatherstation.Observable;
import com.systemdesign.lld.observerpattern.core.weatherstation.Observer;
import com.systemdesign.lld.observerpattern.features.weatherstation.observable.WeatherStation;
import com.systemdesign.lld.observerpattern.features.weatherstation.observers.CurrentConditionDisplay;
import com.systemdesign.lld.observerpattern.features.weatherstation.observers.ForecastDisplay;

public class WeatherStationMainRunner {
    public static void main(String[] args) {
        System.out.println("***Observer Design Pattern***");

        Observable weatherStation = new WeatherStation();

        Observer currenCondtionObserver = new CurrentConditionDisplay(weatherStation);
        Observer forecastDisplayObserver = new ForecastDisplay(weatherStation);

        weatherStation.addObserver(currenCondtionObserver);
        weatherStation.addObserver(forecastDisplayObserver);

        System.out.println("*** Initial Weather Update ***");
        weatherStation.setWeatherReadings(40, 87, 90);

        weatherStation.removeObserver(currenCondtionObserver);

        weatherStation.notifyObserver();
    }
}