package com.github.bakerybluprint.croissant.week_04.dy.example.Bridge;

import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.Button;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.abst.TextArea;
import com.github.bakerybluprint.croissant.week_04.dy.example.abstractFactory02.concreate.FactoryInstance;

public class Main3 {
    public static void main(String[] args) {

        // 기능과 구현을 분리!
        PrintMorseCode code = new PrintMorseCode(new DefulatMCF());
       // PrintMorseCode code = new PrintMorseCode(new DefulatMCF());
        code.g().a().r().a().m();
    }
}
