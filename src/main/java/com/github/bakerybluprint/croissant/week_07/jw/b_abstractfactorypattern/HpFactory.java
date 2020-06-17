package com.github.bakerybluprint.croissant.week_07.jw.b_abstractfactorypattern;

public class HpFactory implements ItemFactory{

	@Override
	public ItemInfo createItemInfo() {
		// TODO Auto-generated method stub
		return new HpInfo();
	}

	@Override
	public ItemInstance createItemInstance() {
		// TODO Auto-generated method stub
		return new HpInstance();
	}

	@Override
	public ItemLog createItemLog() {
		// TODO Auto-generated method stub
		return new HpLog();
	}

}
