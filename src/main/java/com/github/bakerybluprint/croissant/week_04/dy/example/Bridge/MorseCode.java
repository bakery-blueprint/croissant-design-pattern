package com.github.bakerybluprint.croissant.week_04.dy.example.Bridge;

public class MorseCode {

    private MorseCodeFunction function;

    public MorseCode(MorseCodeFunction function) {
        this.function = function;
    }

    // 델리게이트
    public void dot() {
        this.function.dot();
    }

    public void dash() {
        this.function.dash();
    }

    public void space() {
        this.function.space();
    }
}
