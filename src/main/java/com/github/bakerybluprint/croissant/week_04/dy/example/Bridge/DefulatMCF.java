package com.github.bakerybluprint.croissant.week_04.dy.example.Bridge;

public class DefulatMCF implements MorseCodeFunction{

    @Override
    public void dot() {
        System.out.println(".");
    }

    @Override
    public void dash() {
        System.out.println("-");
    }

    @Override
    public void space() {
        System.out.println(" ");
    }
}
