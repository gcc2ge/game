package com.gcc2ge.game.ai;

import com.gcc2ge.game.entity.Oriention;

public class GridXY implements PointXY{
	float x,y;
	public GridXY(float x,float y){
		this.x=x;
		this.y=y;
	}
	@Override
	public float getX() {
		
		return x;
	}

	@Override
	public float getY() {
		
		return y;
	}

	@Override
	public float angleTo(PointXY otherPointXY) {
		double d=Math.atan2(otherPointXY.getY()-this.getY(), otherPointXY.getX()-this.getX())/Math.PI;
		if(d==0){
			return Oriention.RIGHT.direction;
		}else if(d==0.5){
			return Oriention.UP.direction;
		}else if(d==1){
			return Oriention.LEFT.direction;
		}else if(d==-0.5){
			return Oriention.DOWN.direction;
		}
		return 0;
	}

	@Override
	public float distanceXY(PointXY otherPointXY) {
		return this.distance(otherPointXY.getX(), otherPointXY.getY());
	}

	@Override
	public float distance(float otherX, float otherY) {
		return Math.abs(x-otherX)+Math.abs(y-otherY);
	}
	@Override
	public String toString(){
		return "["+x+","+y+"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GridXY other = (GridXY) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}
	
}
