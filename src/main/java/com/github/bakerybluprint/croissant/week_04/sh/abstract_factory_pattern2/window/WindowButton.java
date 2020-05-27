package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.window;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Button;

public class WindowButton implements Button {
    @Override
    public void click() {
        System.out.println("This Button is for Window.");
    }
}
