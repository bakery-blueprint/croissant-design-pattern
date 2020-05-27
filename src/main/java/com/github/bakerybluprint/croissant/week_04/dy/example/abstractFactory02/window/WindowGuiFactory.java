package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.window;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.Button;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.TextArea;

public class WindowGuiFactory implements GuiFactory {

    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public TextArea createTextArea() {
        return new WindowTextArea();
    }
}
