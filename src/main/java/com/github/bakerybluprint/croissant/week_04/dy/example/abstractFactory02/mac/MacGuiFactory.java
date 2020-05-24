package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.mac;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.Button;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.TextArea;

public class MacGuiFactory implements GuiFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextArea createTextArea() {
        return new MacTextArea();
    }
}
