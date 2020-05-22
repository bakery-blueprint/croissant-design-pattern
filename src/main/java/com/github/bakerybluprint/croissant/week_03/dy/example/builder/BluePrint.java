package com.github.bakerybluprint.croissant.week_03.dy.example.builder;

public abstract class BluePrint {
    abstract public void setCpu();
    abstract public void setRam();
    abstract public void setStorage();

    public abstract Computer getComputer();
}
