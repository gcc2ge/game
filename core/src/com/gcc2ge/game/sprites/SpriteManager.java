package com.gcc2ge.game.sprites;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;

public class SpriteManager {
	static Map<String,Texture> textureMap=new HashMap<String , Texture>();
	public static void addTexture(String path,Texture texture){
		textureMap.put(path, texture);
	}
	public static  Texture getTexture(String path){
		if(textureMap.containsKey(path)){
			return textureMap.get(path);
		}
		return null;
	}
}
