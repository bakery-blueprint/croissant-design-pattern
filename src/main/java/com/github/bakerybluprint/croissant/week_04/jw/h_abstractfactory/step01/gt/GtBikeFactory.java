package com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step01.gt;


import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step01.abst.BikeFactory;
import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step01.abst.Body;
import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step01.abst.Wheel;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:37 오후
 */
public class GtBikeFactory implements BikeFactory {
    @Override
    public Body createBody() {
        return new GtBody();
    }

    @Override
    public Wheel createWheel() {
        return new GtWheel();
    }
}
