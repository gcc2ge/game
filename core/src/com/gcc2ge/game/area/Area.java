package com.gcc2ge.game.area;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ͼ��ʵ�壬������ �� ���й���
 * ˢ��
 * @author gcc2ge
 *
 */
public class Area {
	private final AreaEntityList entityList;
	//������
	private final List<Portal> portalList;
	
	public Area(){
		entityList=new AreaEntityList();
		portalList=new ArrayList<Portal>();
	}
}
