package com.github.bakerybluprint.croissant.week_03.sh.builder1;

public class ComputerFactory {

    private BluePrint bluePrint;

    public void setBluePrint(BluePrint bluePrint) {
        this.bluePrint = bluePrint;
    }

    public void make() {
        bluePrint.setCpu();
        bluePrint.setRam();
        bluePrint.setStrorage();
    }

    public Computer get() {
        return bluePrint.getComputer();
    }
}
