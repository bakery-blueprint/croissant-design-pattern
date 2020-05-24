package com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.abst.BikeFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.abst.Body;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.abst.Wheel;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory.sam.SamFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.Button;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.TextArea;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.concreate.FactoryInstance;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.linux.LinuxGuiFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.window.WindowGuiFactory;

public class Main3 {
    public static void main(String[] args) {

        GuiFactory factory = FactoryInstance.getGuiFactory();

        Button button = factory.createButton();
        TextArea textArea = factory.createTextArea();
        button.click();
        System.out.println(textArea);

    }
}
