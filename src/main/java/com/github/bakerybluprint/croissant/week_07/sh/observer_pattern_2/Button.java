package com.github.bakerybluprint.croissant.week_07.sh.observer_pattern_2;

import java.util.Observable;

public class Button extends Observable {
    public void onClick() {
        setChanged();
        notifyObservers();
    }
}
