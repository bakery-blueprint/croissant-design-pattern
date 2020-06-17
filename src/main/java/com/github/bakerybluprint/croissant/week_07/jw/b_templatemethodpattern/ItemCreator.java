package com.github.bakerybluprint.croissant.week_07.jw.b_templatemethodpattern;

public abstract class ItemCreator {
	
	public void templateMethod() {
		process();
		
		requestItemInfo();
		
		createItemLog();
	}
	
	private void process() {
		System.out.println("templatemethod process...");
	}
	
	abstract public void requestItemInfo();
	
	abstract protected void createItemLog();
}
