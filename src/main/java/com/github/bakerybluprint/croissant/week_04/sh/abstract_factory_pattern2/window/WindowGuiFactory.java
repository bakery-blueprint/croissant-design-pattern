package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.window;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Button;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.GuiFactory;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Textarea;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.mac.MacButton;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.mac.MacTextarea;

public class WindowGuiFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public Textarea createTextarea() {
        return new WindowTextarea();
    }
}
