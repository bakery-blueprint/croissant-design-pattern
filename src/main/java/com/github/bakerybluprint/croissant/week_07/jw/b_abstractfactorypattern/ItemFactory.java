package com.github.bakerybluprint.croissant.week_07.jw.b_abstractfactorypattern;

public interface ItemFactory {
	ItemInfo createItemInfo();
	ItemInstance createItemInstance();
	ItemLog createItemLog();
}
