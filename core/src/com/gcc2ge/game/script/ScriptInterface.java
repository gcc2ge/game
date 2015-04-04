package com.gcc2ge.game.script;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gcc2ge.game.sprites.SpriteManager;


public class ScriptInterface {
	public TextureRegion[][] createTextureRegions(String resource,int width,int height){
		return TextureRegion.split(SpriteManager.getTexture(resource),	 width, height);
	}
	public Animation createAnimation(TextureRegion[] regions,int duration) {
		return new Animation(duration,regions);
	}
}
