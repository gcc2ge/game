package com.gcc2ge.game.entity;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.gcc2ge.game.Transition;
import com.gcc2ge.game.Transition.TransitionCallBack;
import com.gcc2ge.game.ai.AStar;
import com.gcc2ge.game.ai.GridCartographer;
import com.gcc2ge.game.ai.GridSpaceTester;
import com.gcc2ge.game.ai.GridXY;
import com.gcc2ge.game.ai.PathFinder;
import com.gcc2ge.game.ai.SpaceTester;

public class Character extends Entity{
	final String TAG=Character.class.getName();
	Oriention oriention=Oriention.DOWN;
	State state=State.IDLE;
	
	//speed
	int walkSpeed=100;
	//pathing
	GridXY destination =null;
	Transition movement = null;
	Iterator path=null;
	PathFinder pathFinder=null;
	GridXY newDestination=null;
	//TransitionCallBack
	TransitionCallBack callBack=new TransitionCallBack() {
		
		@Override
		public void onStart(float value,Oriention direction) {
			updatePosition(value,direction);
			
		}
		
		@Override
		public void onProgress(float value,Oriention direction) {
			Gdx.app.log(TAG, value+" this");
			updatePosition(value,direction);
		}
		
		@Override
		public void onEnd(float value,Oriention direction) {
			updatePosition(value,direction);
			//更换新的路径
			if(newDestination!=null){
				Character.this.moveTo((int)newDestination.getX(), (int)newDestination.getY());
			}else{
				if(path!=null && path.hasNext()){
					Character.this.nextStep();
				}else{
					
				}
			}
			
		}
	};
	public Character(){
		movement=new Transition();
		pathFinder=new PathFinder();
	}
	
	public void go(int screenX,int screenY){
		//do something
		if(path!=null && path.hasNext()){//正在移动 过程中改变状态
			newDestination=new GridXY(screenX,screenY);
		}else{
			moveTo(screenX,screenY);
		}
	}
	public void moveTo(int gridX,int gridY){
		destination=new GridXY(gridX, gridY);
		newDestination=null;
		GridXY startXY=new GridXY(MathUtils.floor(this.positionX/TILEWIDTH),MathUtils.floor(this.positionY/TILEHEIGHT));
		path=pathFinder.findPath(startXY, destination);
		followPath();
//		if(pathFinder.steps>1){
//		}else{
//			path=null;
//		}
	}
	public void followPath(){
		//do something
		nextStep();
	}
	public void nextStep(){
		if(path==null)
			return;
		if(path.hasNext()){
			GridXY gridXY=(GridXY)path.next();
			changeDirection(gridXY);
			switch(this.oriention){
				case LEFT:
					movement.start(this.positionX,gridXY.getX()*TILEWIDTH , -1*walkSpeed,this.oriention, callBack);
					break;
				case RIGHT:
					movement.start(this.positionX,gridXY.getX()*TILEWIDTH , walkSpeed,this.oriention, callBack);
					break;
				case DOWN:
					movement.start(this.positionY,gridXY.getY()*TILEHEIGHT , -1*walkSpeed,this.oriention, callBack);
					break;
				case UP:
					movement.start(this.positionY,gridXY.getY()*TILEHEIGHT , walkSpeed,this.oriention, callBack);
					break;
			}
		}
	}
	//更新坐标
	public void updatePosition(float value,Oriention oriention){
		switch(oriention){
			case LEFT:
				Character.this.positionX=value;
				break;
			case RIGHT:
				Character.this.positionX=value;
				break;
			case UP:
				Character.this.positionY=value;
				break;
			case DOWN:
				Character.this.positionY=value;
				break;
		}
		Gdx.app.log(TAG, "["+this.positionX+","+this.positionY+"]");
	}
	/**
	 * 改变方向
	 * @param target
	 */
	public void changeDirection(GridXY target){
		GridXY g=new GridXY(this.positionX/TILEWIDTH,this.positionY/TILEHEIGHT);
		int d=(int)g.angleTo(target);
		this.oriention=Oriention.getOriention(d);
		Gdx.app.log(TAG, "oriention "+this.oriention);
	}
	/**
	 * 动画
	 */
	public void walk(){
		
	}
	public void idle(){
		
	}
	public void atk(){
		
	}
	/**
	 * game loop 调用
	 */
	public void update(){
		movement.step();
	}
}
