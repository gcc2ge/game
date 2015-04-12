package com.gcc2ge.game.area;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.gcc2ge.game.ai.GridXY;
import com.gcc2ge.game.entity.Entity;

public class AreaEntityList {
	private Set<Entity> entitiesSet;
	private Map<GridXY,Entity> entities;
	
	private enum ClassType{
		PC,NPC,CHEST,ITEM,WEAPON,ARMOR
	}
	//EntityManager
	
	public AreaEntityList(){
		entities=new HashMap<GridXY,Entity>();
		entitiesSet=new HashSet<Entity>();
	}
	public final boolean containsEntity(Entity entity){
		return entitiesSet.contains(entity);
	}
	// add/get entity to/from areaentitylist
}
