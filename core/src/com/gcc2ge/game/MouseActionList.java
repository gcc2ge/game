package com.gcc2ge.game;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonValue;
import com.gcc2ge.game.resource.ResourceManager;
import com.gcc2ge.game.util.JsonUtil;

public class MouseActionList {
	public enum Condition{
		Loot,Attack,Talk,Move,Travel
	}
	private final Map<Condition,String> mouseCursors;
	
	public MouseActionList(){
		FileHandle file=ResourceManager.getResourceAsFileHandle("img/mouse/mouseActions.json");
		JsonValue map=JsonUtil.parse(file);
		mouseCursors=new HashMap<MouseActionList.Condition, String>();
		for(JsonValue entity=map.child();entity!=null;entity=entity.next()){
			Condition condition=Condition.valueOf(entity.asString());
			mouseCursors.put(condition, entity.asString());
		}
		
	}
	
}
