package com.gcc2ge.game.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class AnimationTile {
	static final String TAG=AnimationTile.class.getName();
	float x,y,delay;
	final TextureRegion[] regions;
	Animation animation;
	
	float time=0;
	TextureRegion currentRegion=null;
	public AnimationTile(float x,float y,float delay,int startId,int length,TiledMap map){
		this.regions=new TextureRegion[length];
		for(int i=0;i<length;i++){
			regions[i]=map.getTileSets().getTileSet(0).getTile(startId).getTextureRegion();
			startId+=1;
		}
		this.x=x;this.y=y;
		this.delay=delay;
		this.animation=new Animation(delay, this.regions);
		animation.setPlayMode(Animation.PlayMode.LOOP);
	}
	public void tick(){
		time+=Gdx.graphics.getDeltaTime();
		currentRegion=animation.getKeyFrame(time);
	}
	public void render(SpriteBatch batch){
		batch.draw(currentRegion, x, y);
	}
}
