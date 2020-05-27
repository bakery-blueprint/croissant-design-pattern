package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.abst.BikeFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.abst.Body;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.abst.Wheel;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.gt.GtFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern1.samcheonri.SamFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        BikeFactory factory1 = new SamFactory();
        Body body1 = factory1.createBody();
        Wheel wheel1 = factory1.createWheel();

        log.info(String.valueOf(body1.getClass()));
        log.info(String.valueOf(wheel1.getClass()));

        BikeFactory factory2 = new GtFactory();
        Body body2 = factory2.createBody();
        Wheel wheel2 = factory2.createWheel();

        log.info(String.valueOf(body2.getClass()));
        log.info(String.valueOf(wheel2.getClass()));
    }
}
