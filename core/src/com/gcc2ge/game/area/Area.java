package com.gcc2ge.game.area;

import java.util.ArrayList;
import java.util.List;

/**
 * 地图上实体，传送门 等 进行管理
 * 刷怪
 * @author gcc2ge
 *
 */
public class Area {
	private final AreaEntityList entityList;
	//传送门
	private final List<Portal> portalList;
	
	public Area(){
		entityList=new AreaEntityList();
		portalList=new ArrayList<Portal>();
	}
}
