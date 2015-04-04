package com.gcc2ge.game.script;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GroovyEngine {
	private boolean inUse;
	private final ScriptEngine engine;
	public GroovyEngine(ScriptEngineManager manager){
		this.engine=manager.getEngineByName("groovy");
	}
	public void setInUse(boolean isUse){
		this.inUse=inUse;
	}
	public boolean inUse(){
		return inUse;
	}
	public void put(String key,Object value){
		engine.put(key, value);
	}
	public Object eval(String script) throws ScriptException{
		if(!inUse) throw new IllegalStateException("groovy engine already in use!");
		return engine.eval(script);
	}
	public Object invokeFunction(String function,Object...args) throws NoSuchMethodException, ScriptException{
		if(!inUse) throw new IllegalStateException("groovy engine already in use!");
		return ((Invocable)engine).invokeFunction(function, args);
	}
	public boolean hasFunction(String function){
		if(!inUse) throw new IllegalStateException("groovy engine already in use!");
		Bindings bindings=engine.getBindings(ScriptContext.ENGINE_SCOPE);
		return bindings.containsKey(function);
	}
	public void release(){
		this.inUse=false;
		engine.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
	}
	
}
