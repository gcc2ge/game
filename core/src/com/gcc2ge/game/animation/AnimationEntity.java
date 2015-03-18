package com.gcc2ge.game.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/**
 * 
 * @author Administrator
 *
 */
public class AnimationEntity {
	int length,row;
	Animation animation=null;
	public AnimationEntity(){}
	public AnimationEntity(int length,int row){
		this.length=length;
		this.row=row;
	}
	public void createAnimation(TextureRegion[][] textureRegion){
		TextureRegion[] region=new TextureRegion[length];
		for(int i=0;i<length;i++){
			region[i]=textureRegion[row][i];
		}
		animation=new Animation(2, region);
	}
	
}
