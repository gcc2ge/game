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
	final int TILEWIDTH=16;
	final int TILEHEIGHT=16;
	public float positionX=(Gdx.graphics.getWidth()/TILEWIDTH)*TILEWIDTH,positionY=(Gdx.graphics.getHeight()/TILEHEIGHT)*TILEHEIGHT;

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
	Animation a=MyGdxGame.spriteManager.getAnimation("clotharmor_idle_down");
	public void render(SpriteBatch batch){
		time+=Gdx.graphics.getRawDeltaTime();
		TextureRegion r=a.getKeyFrame(time);
		batch.draw(r, this.positionX-12, this.positionY-8);
	}
}
