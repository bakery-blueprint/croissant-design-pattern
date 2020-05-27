package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.window;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.Button;

public class WindowButton implements Button {
    @Override
    public void click() {
        System.out.println("windowButton");
    }
}
