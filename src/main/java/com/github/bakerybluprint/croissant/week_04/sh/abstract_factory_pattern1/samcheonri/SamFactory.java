package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.samcheonri;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.abst.BikeFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.abst.Body;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.abst.Wheel;

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
