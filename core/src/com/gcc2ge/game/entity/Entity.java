package com.gcc2ge.game.entity;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.gcc2ge.game.AssetLoader;
import com.gcc2ge.game.animation.AnimationEntity;
import com.gcc2ge.game.sprites.Sprite;

/**
 * 
 * @author Administrator
 * 主要用户显示
 */
public class Entity {
	public float positionX=Gdx.graphics.getWidth(),positionY=Gdx.graphics.getHeight();
//	int gridPositionX,gridPositionY;
	final int TILEWIDTH=16;
	final int TILEHEIGHT=16;
	//人物 动画  
	Map<String,AnimationEntity> animations;
	int x,y;
	
	public void setSprite(Sprite sprite){
		
	}
	
	
	public void test(){
//		System.out.println(oriention+"_"+state);
	}
	public static void main(String... args){
		new Entity().test();
	}
	
	public void render(ShapeRenderer shapeRender){
		shapeRender.begin(ShapeType.Filled);
		// set to green for full mob health
		shapeRender.setColor(0, 254, 0, 1);
		shapeRender.circle(positionX+8, positionY+8, 8);
		shapeRender.end();
	}
}
