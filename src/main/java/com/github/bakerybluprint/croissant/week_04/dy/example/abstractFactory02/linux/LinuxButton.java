package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.linux;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.Button;

public class LinuxButton implements Button {
    @Override
    public void click() {
        System.out.println("linuxButton");
    }
}
