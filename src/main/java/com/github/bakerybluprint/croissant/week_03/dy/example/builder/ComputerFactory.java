package com.github.bakerybluprint.croissant.week_03.dy.example.builder;

public class ComputerFactory {

    private BluePrint bluePrint;

    public void setBluePrint(BluePrint blueprint) {
        this.bluePrint = blueprint;
    }

    public void make() {
        bluePrint.setCpu();
        bluePrint.setRam();
        bluePrint.setStorage();
    }

    public Computer getComputer() {
        return bluePrint.getComputer();
    }
}
