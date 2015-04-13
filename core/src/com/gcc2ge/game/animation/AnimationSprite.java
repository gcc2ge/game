package com.gcc2ge.game.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * animation 的代理类
 * @author Administrator
 *
 */
public class AnimationSprite {
	float stateTime=0f;
	Animation animation;
	public void reset(){
		stateTime=0f;
	}
	public AnimationSprite (float frameDuration, Array<? extends TextureRegion> keyFrames) {
		animation=new Animation(frameDuration,keyFrames);
	}
	
	public AnimationSprite (float frameDuration, Array<? extends TextureRegion> keyFrames, PlayMode playMode) {
		animation=new Animation(frameDuration,keyFrames,playMode);
	}

	public AnimationSprite (float frameDuration, TextureRegion... keyFrames) {
		animation=new Animation(frameDuration,keyFrames);
	}

	public TextureRegion getKeyFrame ( boolean looping) {
		stateTime+=Gdx.graphics.getDeltaTime();
		return animation.getKeyFrame(stateTime,looping);
	}

	public TextureRegion getKeyFrame () {
		stateTime+=Gdx.graphics.getDeltaTime();
		return animation.getKeyFrame(stateTime);
	}

	public int getKeyFrameIndex () {
		stateTime+=Gdx.graphics.getDeltaTime();
		return animation.getKeyFrameIndex(stateTime);
	}

	public TextureRegion[] getKeyFrames () {
		return animation.getKeyFrames();
	}

	public PlayMode getPlayMode () {
		return animation.getPlayMode();
	}

	public void setPlayMode (PlayMode playMode) {
		animation.setPlayMode(playMode);
	}

	public boolean isAnimationFinished () {
		return animation.isAnimationFinished(stateTime);
	}

	public void setFrameDuration (float frameDuration) {
		animation.setFrameDuration(frameDuration);
	}
	
	public float getFrameDuration () {
		return animation.getFrameDuration();
	}

	public float getAnimationDuration () {
		return animation.getAnimationDuration();
	}
}
