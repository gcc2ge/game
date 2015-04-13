package com.gcc2ge.game.area;
/**
 * 传送入口
 * @author gcc2ge
 *
 */
public class Portal {
	//
	public Location fromLocation;//目标地点
	public Location targetLocation;
	public Portal(){}
	public void setFromLocation(Location location){
		this.fromLocation=location;
	}
	public void setTargetLocation(Location location){
		this.targetLocation=location;
	}
	
}
