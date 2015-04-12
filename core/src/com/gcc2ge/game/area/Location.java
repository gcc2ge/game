package com.gcc2ge.game.area;

import com.gcc2ge.game.ai.GridXY;

public class Location {
	private final Area area;
	private final float x,y;
	public Location(Area area,float x,float y){
		this.area=area;
		this.x=x;
		this.y=y;
	}
	public Location (Area area,GridXY xy){
		this.area=area;
		this.x=xy.getX();
		this.y=xy.getY();
	}
	public Area getArea(){
		return this.area;
	}
	public float getX(){
		return this.x;
	}
	public float getY(){
		return this.y;
	}
	public float getDistance(float x,float y){
		return distance(x,y);
	}
	public float getDistance(Location l){
		return distance(l.x,l.y);
	}
	//
	public float distance(float otherX, float otherY) {
		return Math.abs(x-otherX)+Math.abs(y-otherY);
	}
	//get current position entity
	
}
