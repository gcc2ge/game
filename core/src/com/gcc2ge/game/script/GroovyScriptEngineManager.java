package com.gcc2ge.game.script;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngineManager;

public class GroovyScriptEngineManager {
	private final ScriptEngineManager manager;
	private final List<GroovyEngine> engines;
	public GroovyScriptEngineManager(){
		this.manager=new ScriptEngineManager();
		this.engines=new ArrayList<GroovyEngine>();
	}
	public GroovyEngine getEngine(){
		for(GroovyEngine engine:engines){
			if(!engine.inUse()){
				engine.setInUse(true);
				return engine;
			}
		}
		GroovyEngine engine=new GroovyEngine(manager);
		engine.setInUse(true);
		engines.add(engine);
		return engine;
	}
}
