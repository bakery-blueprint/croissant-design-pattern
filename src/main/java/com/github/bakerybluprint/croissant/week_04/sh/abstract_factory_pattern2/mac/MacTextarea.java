package com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.mac;

import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Button;
import com.github.bakerybluprint.croissant.week_04.sh.abstract_factory_pattern2.abst.Textarea;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MacTextarea implements Textarea {
    @Override
    public String getTextarea() {
        return "Text for Mac.";
    }
}
