package com.gcc2ge.game.area;
/**
 * �������
 * @author gcc2ge
 *
 */
public class Portal {
	//
	public Location fromLocation;//Ŀ��ص�
	public Location targetLocation;
	public Portal(){}
	public void setFromLocation(Location location){
		this.fromLocation=location;
	}
	public void setTargetLocation(Location location){
		this.targetLocation=location;
	}
	
}
