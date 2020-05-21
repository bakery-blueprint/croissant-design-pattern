package com.github.bakerybluprint.croissant.week_03.sh.builder1;

public abstract class BluePrint {
    abstract public void setCpu();
    abstract public void setRam();
    abstract public void setStrorage();

    public abstract Computer getComputer();
}
