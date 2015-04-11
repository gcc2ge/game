package com.gcc2ge.game.sprites;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.script.ScriptException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.gcc2ge.game.MyGdxGame;
import com.gcc2ge.game.resource.ResourceManager;
import com.gcc2ge.game.script.GroovyEngine;

public class SpriteManager {
	private static final String TAG=SpriteManager.class.getName();
	static Map<String,Texture> textureMap=new HashMap<String , Texture>();
	
	private final Map<String,Animation> baseAnimations;
	
	public SpriteManager(){
		this.baseAnimations=new HashMap<String,Animation>();
	}
	
	public static void addTexture(String path,Texture texture){
		textureMap.put(path, texture);
	}
	public static  Texture getTexture(String path){
		if(textureMap.containsKey(path)){
			return textureMap.get(path);
		}
		return null;
	}
	/**
	 * 动画与粒子
	 */
	public void loadResource(){
		//粒子
		
		//动画
		Set<String> resources=ResourceManager.getResourceInDirectory("scripts/animations");
		for(String resource:resources){
			loadAnimation(resource);
		}
	}
	private void loadAnimation(String resource){
		GroovyEngine engine=MyGdxGame.scriptEngineManager.getEngine();
		engine.put("game", MyGdxGame.scriptInterface);
		Map<String,Animation> animation=null;
		try {
			animation=(Map<String,Animation>) engine.eval(ResourceManager.getResourceAsString(resource));
		} catch (ScriptException e) {
			Gdx.app.log(TAG, "载入动画出错: "+resource);
			e.printStackTrace();
		}
		if(animation!=null){
			for(String animationName:animation.keySet()){
				this.baseAnimations.put(animationName, animation.get(animationName));
			}
		}
	}
	public Animation getAnimation(String ref) {
		Animation a = this.baseAnimations.get(ref);
		a.setPlayMode(Animation.PlayMode.LOOP);
		if (a == null) return null;
		
		return a;
	}
}
