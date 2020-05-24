package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.window;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.TextArea;

public class WindowTextArea implements TextArea {
    @Override
    public String getText() {
        return "windowTextarea";
    }
}
