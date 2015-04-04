package com.gcc2ge.game.script;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gcc2ge.game.sprites.SpriteManager;


public class ScriptInterface {
	public TextureRegion[][] createTextureRegions(String resource,int width,int height){
		return TextureRegion.split(SpriteManager.getTexture(resource),	 width, height);
	}
	public Animation createAnimation(List<TextureRegion> regions,float duration) {
		return new Animation(duration,regions.toArray(new TextureRegion[]{}));
	}
	public TextureRegion cloneTextureRegion(TextureRegion r){
		return new TextureRegion(r);
	}
}
