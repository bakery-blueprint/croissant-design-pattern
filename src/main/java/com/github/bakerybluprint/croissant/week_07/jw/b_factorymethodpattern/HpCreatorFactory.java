package com.github.bakerybluprint.croissant.week_07.jw.b_factorymethodpattern;

import java.util.Date;


public class HpCreatorFactory extends ItemCreatorFactory{

	@Override
	public void requestItemInfo() {
		// TODO Auto-generated method stub
		System.out.println("DB���� ü��ȸ�� ������ ������ �������� �ֽ��ϴ�.");
		
	}

	@Override
	protected void createItemLog() {
		// TODO Auto-generated method stub
		System.out.println("DB���� ü��ȸ�� ������ ������ �����Խ��ϴ�!"+new Date());
	}
	
	
	/*�߻� Ŭ������ �����ϸ� ������ ���谡 �̷������ ���Ѵ�.*/
	@Override
	protected Item createInstance() {
		// TODO Auto-generated method stub
		return new HpPotion();
	}
	
}
