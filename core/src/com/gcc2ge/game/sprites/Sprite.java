package com.gcc2ge.game.sprites;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gcc2ge.game.AssetLoader;
import com.gcc2ge.game.animation.AnimationEntity;
import com.gcc2ge.game.entity.Oriention;
import com.gcc2ge.game.entity.State;
/**
 * 
 * @author Administrator
 *	sprite json 配置数据
 */
public class Sprite {
	String id;//动画 图片 名称
	String name;
	int offsetX,offsetY;
	int width,height;
	//人物
	Map<String,AnimationEntity> animations=new HashMap<String ,AnimationEntity>();
	public Sprite(){
		
	}
	public Sprite(String name){
	}
	//get current animation
	public void createAnimation(){
//		Texture texture=AssetLoader.getSprite(id);
//		TextureRegion[][] textureRegion=TextureRegion.split(texture, width, height);
//		for(Map.Entry<String, AnimationEntity> entry:animations.entrySet()){
//			entry.getValue().createAnimation(textureRegion);
//		}
		
	}
	//get hurted animation
	
	public void render(Oriention oriention ,State state,SpriteBatch batch){
		String animationName=oriention+"_"+state;
		animations.get(animationName);
	}
}

