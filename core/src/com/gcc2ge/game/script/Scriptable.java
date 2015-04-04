package com.gcc2ge.game.script;

import java.util.HashSet;
import java.util.Set;

import javax.script.ScriptException;

import com.badlogic.gdx.Gdx;
import com.gcc2ge.game.MyGdxGame;

public class Scriptable {
	private final String TAG=Scriptable.class.getName();
	private final String scriptLocation;
	private final String script;
	private final boolean inline;
	private final Set<ScriptFunctionType> scriptFunctions;
	public Scriptable(String script,String location,boolean isinline){
		scriptFunctions=new HashSet<ScriptFunctionType>();
		this.script=script;
		this.scriptLocation=location;
		this.inline=isinline;
		if(script!=null){
			GroovyEngine engine=MyGdxGame.scriptEngineManager.getEngine();
			try {
				engine.eval(script);
			} catch (ScriptException e) {
				Gdx.app.log(TAG, "脚本解析出错 ！ 文件地址"+scriptLocation);
			}
//			for(ScriptFunctionType type:ScriptFunctionType.values()){
//				if(engine.hasFunction(type.toString())){
//					
//				}
//			}
			engine.release();
		}
	}
	public Scriptable(Scriptable other){
		this.script=other.script;
		this.scriptLocation=other.scriptLocation;
		this.inline=other.inline;
		this.scriptFunctions=new HashSet<ScriptFunctionType>();
	}
	public int getNumberOfScriptFunctions(){
		return scriptFunctions.size();
	}
	public Object executeFunction(ScriptFunctionType type,Object ... args){
		return executeFunction(type.toString(), args);
	}
	public Object executeFunction(String function, Object argument) {
		Object[] args = new Object[1];
		args[0] = argument;
		
		return executeFunction(function, args);
	}
	public Object executeFunction(String function, Object arg1, Object arg2) {
		Object[] args = new Object[2];
		args[0] = arg1;
		args[1] = arg2;
		
		return executeFunction(function, args);
	}
	public Object executeFunction(String function, Object... arguments) {
		Object returnValue = null;
		
		GroovyEngine engine = MyGdxGame.scriptEngineManager.getEngine();
		
		try {
			// script has already been pre-parsed; eval should not return any errors
			engine.eval(script);
			returnValue = engine.invokeFunction(function, Scriptable.createArgumentList(arguments));
		} catch (ScriptException e) {
			Gdx.app.log(TAG, "Error invoking function " + function +
					" for script " + scriptLocation);
		} catch (NoSuchMethodException e) {
			Gdx.app.log(TAG,"Error invoking function " + function +
					" for script " + scriptLocation);
		}
		
		engine.release();
		
		return returnValue;
	}
	private static Object[] createArgumentList(Object... arguments) {
		Object[] args = new Object[arguments.length + 1];
		args[0] =MyGdxGame.scriptInterface;
		int i = 1;
		for (Object obj : arguments) {
			args[i] = obj;
			i++;
		}
		return args;
	}
	public String getScript() { return script; }
	public String getScriptLocation() { return scriptLocation; }
}
