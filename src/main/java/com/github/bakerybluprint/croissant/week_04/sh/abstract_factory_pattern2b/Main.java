package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b.abst.Button;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b.abst.Textarea;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2b.concrete.FactoryInstance;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        GuiFactory factory = FactoryInstance.getGuiFactory();
        Button button = factory.createButton();
        Textarea textarea = factory.createTextarea();

        button.click();
        System.out.println(textarea.getTextarea());
    }
}
