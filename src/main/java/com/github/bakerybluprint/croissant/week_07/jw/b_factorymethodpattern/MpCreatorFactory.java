package com.github.bakerybluprint.croissant.week_07.jw.b_factorymethodpattern;

import java.util.Date;


public class MpCreatorFactory extends ItemCreatorFactory{

	@Override
	public void requestItemInfo() {
		// TODO Auto-generated method stub
		System.out.println("DB���� ����ȸ�� ������ ������ �������� �ֽ��ϴ�.");
		
	}

	@Override
	protected void createItemLog() {
		// TODO Auto-generated method stub
		System.out.println("DB���� ����ȸ�� ������ ������ �����Խ��ϴ�!"+new Date());
	}

	@Override
	protected Item createInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
