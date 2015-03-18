package com.gcc2ge.game.ai;

public interface PointXY {
	public float getX();
	public float getY();
	
	public float angleTo(PointXY otherPointXY);
	public float distanceXY(PointXY otherPointXY);
	public float distance(float otherX,float otherY);
}
