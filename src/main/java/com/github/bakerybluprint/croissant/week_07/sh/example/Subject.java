package com.github.bakerybluprint.croissant.week_07.sh.example;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
