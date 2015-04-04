package com.gcc2ge.game.entity;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gcc2ge.game.MyGdxGame;
import com.gcc2ge.game.animation.AnimationEntity;
import com.gcc2ge.game.sprites.Sprite;
import com.gcc2ge.game.sprites.SpriteManager;

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
	float time;
	Animation a=null;
	public void render(SpriteBatch batch){
		time+=Gdx.graphics.getRawDeltaTime();
		if(a==null){
			a=MyGdxGame.spriteManager.getAnimation("clotharmor_walk_right");
		}
		TextureRegion r=a.getKeyFrame(time);
		batch.draw(r, this.positionX-12, this.positionY-8);
	}
}
