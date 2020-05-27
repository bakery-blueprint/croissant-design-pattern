package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.mac;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Button;

public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("This Button is for Mac.");
    }
}
