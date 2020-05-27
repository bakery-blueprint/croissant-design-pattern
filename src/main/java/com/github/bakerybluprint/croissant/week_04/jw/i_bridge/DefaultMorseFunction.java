package com.github.bakerybluprint.croissant.week_04.jw.i_bridge;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:36 오후
 */
public class DefaultMorseFunction implements MorseCodeFunction{
    @Override
    public void dot() {
        System.out.print(".");
    }

    @Override
    public void dash() {
        System.out.print("-");
    }

    @Override
    public void space() {
        System.out.print(" ");
    }
}
