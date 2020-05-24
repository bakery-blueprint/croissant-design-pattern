package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.linux;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.Button;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.TextArea;

public class LinuxGuiFactory implements GuiFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextArea createTextArea() {
        return new LinuxTextArea();
    }
}
