package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.mac;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.TextArea;

public class MacTextArea implements TextArea {
    @Override
    public String getText() {
        return "MacTextarea";
    }
}
