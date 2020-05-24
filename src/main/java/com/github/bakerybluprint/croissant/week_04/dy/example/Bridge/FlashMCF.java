package com.github.bakerybluprint.croissant.week_04.dy.example.Bridge;

public class FlashMCF implements MorseCodeFunction{

    @Override
    public void dot() {
        System.out.println("반짝");
    }

    @Override
    public void dash() {
        System.out.println("번쩍");
    }

    @Override
    public void space() {
        System.out.println(" ");
    }
}
