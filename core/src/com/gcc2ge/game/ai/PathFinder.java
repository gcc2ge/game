package com.gcc2ge.game.ai;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
/**
 * Â·¾¶Ñ°ÕÒ
 * @author Administrator
 *
 */
public class PathFinder {
	final String TAG=PathFinder.class.getName();
	AStar aStar=null;
	GridCartographer gridCartographer=null;
	SpaceTester spaceTester=null;
	Iterator path=null;
	public int steps=0;
	public PathFinder(){
		spaceTester=new GridSpaceTester();
		gridCartographer=new GridCartographer(spaceTester);
		aStar=new AStar(gridCartographer);
	}
	public Iterator findPath(GridXY startXY,GridXY endXY){
		Gdx.app.log(TAG, "starXY: "+startXY+" endXY: "+endXY);
		gridCartographer.setGoalPointXY(endXY);
		aStar.reset(startXY);
		for(int i=0;i<300;i++){
			aStar.loop();
			if(aStar.isGoalFound()||aStar.isListEmpty())
				break;
		}
		path=aStar.getPath();
		steps=aStar.steps;
		return path;
	}
}
