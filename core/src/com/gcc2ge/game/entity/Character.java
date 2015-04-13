package com.gcc2ge.game.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import com.gcc2ge.game.MyGdxGame;
import com.gcc2ge.game.Transition;
import com.gcc2ge.game.Transition.TransitionCallBack;
import com.gcc2ge.game.ai.GridXY;
import com.gcc2ge.game.ai.PathFinder;

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
	//路径完成回调
	List<Runnable> finishMoveCallback=new ArrayList<Runnable>();
	//TransitionCallBack
	TransitionCallBack callBack=new TransitionCallBack() {
		
		@Override
		public void onStart(float value,Oriention direction) {
			updatePosition(value,direction);
			
		}
		
		@Override
		public void onProgress(float value,Oriention direction) {
			Gdx.app.log(TAG, value+" this");Character.this.state=State.WALK;
			updatePosition(value,direction);
		}
		
		@Override
		public void onEnd(float value,Oriention direction) {
			updatePosition(value,direction);
			//更换新的路径
			if(newDestination!=null){
				Character.this.moveTo((int)newDestination.getX(), (int)newDestination.getY());
			}else{
				if(path!=null && path.hasNext()){//路径为全部完成，继续执行下一个路径
					Character.this.nextStep();
				}else{//路径执行完成
					Character.this.state=State.IDLE;
					if(finishMoveCallback!=null){
						for(Runnable run:finishMoveCallback){
							run.run();
						}
					}
				}
			}
			
		}
	};
	public Character(){
		movement=new Transition();
		pathFinder=new PathFinder();
	}
	
	public void go(int x,int y){
		//do something
		if(path!=null && path.hasNext()){//正在移动 过程中改变状态
			changeCurrentMove(x,y);
		}else{
			moveTo(x,y);
		}
	}
	//改变移动
	public void changeCurrentMove(int x,int y){
		newDestination=new GridXY(x,y);
		if(finishMoveCallback!=null){
			finishMoveCallback.clear();
		}
	}
	//取消当前移动
	public void cancelCurrentMove(){
		path=null;
		if(finishMoveCallback!=null){
			finishMoveCallback.clear();
		}
	}
	//注册移动完成回调
	public void addFinishMoveCallBack(Runnable run){
		finishMoveCallback.add(run);
	}
	public void moveTo(int gridX,int gridY){
		destination=new GridXY(gridX, gridY);
		newDestination=null;
		GridXY startXY=new GridXY(MathUtils.floor(this.positionX/TILEWIDTH),MathUtils.floor(this.positionY/TILEHEIGHT));
		path=pathFinder.findPath(startXY, destination);
		followPath();
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
					movement.start(this.positionX,gridXY.getX()*TILEWIDTH , walkSpeed,this.oriention, callBack);
					break;
				case RIGHT:
					movement.start(this.positionX,gridXY.getX()*TILEWIDTH , walkSpeed,this.oriention, callBack);
					break;
				case DOWN:
					movement.start(this.positionY,gridXY.getY()*TILEHEIGHT , walkSpeed,this.oriention, callBack);
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
		Gdx.app.log(TAG,"before oriention: "+this.oriention);
		GridXY g=new GridXY(this.positionX/TILEWIDTH,this.positionY/TILEHEIGHT);
		int d=(int)g.angleTo(target);
		Gdx.app.log(TAG,"current Position: "+g+" target position: "+target+" oriention angle is: "+d);
		this.oriention=Oriention.getOriention(d);
		Gdx.app.log(TAG, "oriention "+this.oriention);
	}
	/**
	 * 动画
	 */
	public void walk(){
		Animation aa=MyGdxGame.spriteManager.getAnimation("ogre_walk_"+this.oriention);
		this.a=aa;
	}
	public void idle(){
		Animation aa=MyGdxGame.spriteManager.getAnimation("ogre_idle_"+this.oriention);
		this.a=aa;
		
	}
	public void atk(){
		
	}
	public void animation(){
		switch (this.state) {
		case WALK:
			walk();
			break;
		case ATTACK:
			atk();
			break;
		case IDLE:
			idle();
			break;
		default:
			break;
		}
	}
	/**
	 * game loop 调用
	 */
	public void update(){
		animation();
		movement.step();
		
	}
}
