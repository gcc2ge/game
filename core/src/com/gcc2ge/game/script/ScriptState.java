package com.gcc2ge.game.script;

import java.util.HashMap;
import java.util.Map;

public class ScriptState {
	public Map<String,Object> state;
	public ScriptState(){
		this.state=new HashMap<String,Object>();
	}
	public ScriptState(ScriptState other){
		this();
		for(String key:other.state.keySet()){
			this.state.put(key, other.state.get(key));
		}
	}
	public boolean isEmpty(){
		return state.isEmpty();
	}
	public Object get(String key){
		return state.get(key);
	}
	public void put(String key,Object value){
		this.state.put(key, value);
	}
}
