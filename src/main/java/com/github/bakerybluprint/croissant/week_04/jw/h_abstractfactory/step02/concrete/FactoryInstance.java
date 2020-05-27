package com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step02.concrete;


import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step02.abst.Button;
import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step02.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.jw.h_abstractfactory.step02.abst.TextArea;

/**
 * Project : EffectiveStudy
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 3:02 오후
 */
public class FactoryInstance {
     public static GuiFactory getGuiFactory() {

         String property = System.getProperty("os.name");



         switch (getOsCode()) {
             case 0: return new MacGuiFactory();
             case 1: return new LinuxGuiFactory();
         }

         return null;
     }

     private static int getOsCode() {
         if (System.getProperty("os.name").equals("Mac OS X"))
             return 0;

         return 0;
     }
}

class LinuxButton implements Button {
    @Override
    public void click() {
        System.out.println("Linux Button");
    }
}

class LinuxGuiFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextArea createTextArea() {
        return new LinuxTextArea();
    }
}

class LinuxTextArea implements TextArea {
    @Override
    public String getText() {
        return "Linux TextArea";
    }
}

class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("Mac Button");
    }
}

class MacGuiFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextArea createTextArea() {
        return new MacTextArea();
    }
}

class MacTextArea implements TextArea {
    @Override
    public String getText() {
        return "Mac TextArea";
    }
}
