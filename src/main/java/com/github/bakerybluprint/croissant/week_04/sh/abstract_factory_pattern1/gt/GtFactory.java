package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.gt;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.abst.BikeFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.abst.Body;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.abst.Wheel;

public class GtFactory implements BikeFactory {
    @Override
    public Body createBody() {
        return new GtBody();
    }

    @Override
    public Wheel createWheel() {
        return new GtWheel();
    }
}
