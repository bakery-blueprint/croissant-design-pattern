package com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step01.abst;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:31 오후
 */
public interface BikeFactory {

    public Body createBody();
    public Wheel createWheel();
}
