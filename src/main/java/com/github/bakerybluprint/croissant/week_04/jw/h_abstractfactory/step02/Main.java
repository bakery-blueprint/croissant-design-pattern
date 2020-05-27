package com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step02;


import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step02.abst.Button;
import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step02.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step02.abst.TextArea;
import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step02.concrete.FactoryInstance;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:58 오후
 */
public class Main {
    public static void main(String[] args) {
        GuiFactory factory = FactoryInstance.getGuiFactory();

        Button button = factory.createButton();
        TextArea textArea = factory.createTextArea();

        button.click();
        System.out.println(textArea.getText());
    }
}
