package com.gcc2ge.game;

import com.badlogic.gdx.Gdx;
import com.gcc2ge.game.entity.Oriention;
/**
 * 一个路径执行功能
 * @author gcc2ge
 *
 */
public class Transition {
	final String TAG=Transition.class.getName();
	float startValue,endValue,speed;
	float startTime=0f;
	boolean inProgress=false;
	TransitionCallBack callBack;
	Oriention direction;

	public void start(float startValue,float endValue,float speed,Oriention direction,TransitionCallBack callBack){
		this.startValue=startValue;
		this.endValue=endValue;
		this.callBack=callBack;
		this.speed=speed;
		this.direction=direction;
		inProgress=true;
		callBack.onStart(startValue,this.direction);
	}
	public void step(){
		if(!inProgress){
			return;
		}
		switch(this.direction){
			case LEFT:
			case DOWN:
				startValue-=speed*Gdx.graphics.getDeltaTime();
				if(startValue<=endValue){
					inProgress=false;
					startValue=endValue;
				}
				break;
			case RIGHT:
			case UP:
				startValue+=speed*Gdx.graphics.getDeltaTime();
				if(startValue>=endValue){
					inProgress=false;
					startValue=endValue;
				}
				break;
		}
		if(inProgress){
			callBack.onProgress(startValue,this.direction);
		}else{
			callBack.onEnd(startValue,this.direction);
		}
		
	}
	public void stop(){
		inProgress=false;
	}
	public void reStart(float startValue,float endValue){
		this.start(startValue, endValue,this.speed, this.direction,this.callBack);
	}
	public Transition(){
		
	}
	public interface TransitionCallBack{
		void onStart(float value,Oriention direction);
		void onProgress(float value,Oriention direction);
		void onEnd(float value,Oriention direction);
	}
}
