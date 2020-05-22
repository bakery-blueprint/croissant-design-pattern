package com.github.bakerybluprint.croissant.week_03.sh.builder1;

public class LgGramBluePrint extends BluePrint {

    private Computer computer;

    public LgGramBluePrint() {
        computer = new Computer("default","default","default");
    }

    @Override
    public void setCpu() {
        computer.setCpu("i7");
    }

    @Override
    public void setRam() {
        computer.setRam("8GB");
    }

    @Override
    public void setStrorage() {
        computer.setStorage("256GB");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

}
