package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.linux;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.TextArea;

public class LinuxTextArea implements TextArea {
    @Override
    public String getText() {
        return "linuxTextarea";
    }
}
