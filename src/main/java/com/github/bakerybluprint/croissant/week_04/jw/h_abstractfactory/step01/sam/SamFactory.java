package com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step01.sam;


import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step01.abst.BikeFactory;
import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step01.abst.Body;
import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step01.abst.Wheel;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:32 오후
 */
public class SamFactory implements BikeFactory {
    @Override
    public Body createBody() {
        return new SamBody();
    }

    @Override
    public Wheel createWheel() {
        return new SamWheel();
    }
}
