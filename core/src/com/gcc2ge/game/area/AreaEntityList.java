package com.gcc2ge.game.area;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import com.gcc2ge.game.ai.GridXY;
import com.gcc2ge.game.entity.Entity;

public class AreaEntityList implements Iterable<Entity>{
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
	@Override
	public Iterator<Entity> iterator() {
		// TODO Auto-generated method stub
		return new EntityIterator();
	}
	private class EntityIterator implements Iterator<Entity> {
		private Iterator<Entity> hashSetIterator;
		private Entity last;
		
		private EntityIterator() {
			this.hashSetIterator = entitiesSet.iterator();
			last = null;
		}
		
		@Override public boolean hasNext() {
			return hashSetIterator.hasNext();
		}

		@Override public Entity next() {
			last = hashSetIterator.next();
			return last;
		}

		@Override public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
}
