package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Button;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Textarea;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.linux.LinuxGuiFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b.concrete.FactoryInstance;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {

//        GuiFactory factory1 = new MacGuiFactory();
//        GuiFactory factory1 = new WindowGuiFactory();
        GuiFactory factory1 = new LinuxGuiFactory();

        GuiFactory factory = (GuiFactory) FactoryInstance.getGuiFactory();

        Button button1 = factory1.createButton();
        Textarea textarea2 = factory1.createTextarea();

        button1.click();
        System.out.println(textarea2.getTextarea());
    }
}
