package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.sam;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.abst.BikeFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.abst.Body;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.abst.Wheel;

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
