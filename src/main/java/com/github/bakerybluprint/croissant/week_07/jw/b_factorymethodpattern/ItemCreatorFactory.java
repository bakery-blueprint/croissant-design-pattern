package com.github.bakerybluprint.croissant.week_07.jw.b_factorymethodpattern;

public abstract class ItemCreatorFactory {
	
	public void templateMethod() {
		process();
		
		requestItemInfo();
		
		createItemLog();
	}
	
	private void process() {
		System.out.println("���ø� �޼��� ����...");
	}
	
	abstract public void requestItemInfo();
	
	abstract protected void createItemLog();
	
	
	/*�ν��Ͻ��� ������ ���� Ŭ������ �����Ѵ�...*/
	abstract protected Item createInstance();
	
}
