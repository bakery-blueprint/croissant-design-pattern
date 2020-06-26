package com.github.bakerybluprint.croissant.week_07.sh.observer_pattern_3;

public class Button {

    public Button() {
        observable = new Observable<String>();
    }

    private  Observable<String> observable;

    public void addObserver(Observable.Observer<String> o) {
        observable.addObserver(o);
    }

    public void notifyObservers() {
        observable.notifyObservers(null);
    }

    public void onClick() {
        observable.setChanged();
        notifyObservers();
    }
}
