package com.gcc2ge.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonValue;
import com.gcc2ge.game.area.Location;
import com.gcc2ge.game.defaultability.DefaultAbility;
import com.gcc2ge.game.entity.Player;
import com.gcc2ge.game.resource.ResourceManager;
import com.gcc2ge.game.util.JsonUtil;

public class MouseActionList {
	public enum Condition{
		Loot(null),
		Attack(null),
		Talk(null),
		Travel(new com.gcc2ge.game.defaultability.Travel()),
		Move(new com.gcc2ge.game.defaultability.Move());
		private final DefaultAbility ability;
		private Condition(DefaultAbility ability){
			this.ability=ability;
		}
		public DefaultAbility getAbility(){
			if (ability == null) return null;
			else return ability.getInstance();
		}
	}
	private final Map<Condition,String> mouseCursors;
	private final List<Condition> conditionsWithAbility;
	
	public MouseActionList(){
		FileHandle file=ResourceManager.getResourceAsFileHandle("img/mouse/mouseActions.json");
		JsonValue map=JsonUtil.parse(file);
		mouseCursors=new HashMap<MouseActionList.Condition, String>();
		for(JsonValue entity=map.child();entity!=null;entity=entity.next()){
			Condition condition=Condition.valueOf(entity.asString());
			mouseCursors.put(condition, entity.asString());
		}
		conditionsWithAbility = new ArrayList<Condition>();
		for (Condition condition : Condition.values()) {
			if (condition.ability != null) conditionsWithAbility.add(condition);
		}
	}
	public String getMouseCursor(Condition conditon){
		return mouseCursors.get(conditon);
	}
	public Condition getDefalutMouseCondition(Player parent,Location target){
		for(Condition condition:conditionsWithAbility){
			if(condition.ability!=null && condition.ability.canActivate(parent, target)){
				return condition;
			}
		}
		return Condition.Move;
	}
}
