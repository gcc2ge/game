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
	public void addPortal(Portal p){
		portalList.add(p);
	}
	public Portal getPortal(float x,float y){
		for(Portal p:portalList){
			if(p.location.getX()==x && p.location.getY()==y)
				return p;
		}
		return null;
	}
}
