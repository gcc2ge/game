package com.gcc2ge.game.entity;

public enum Oriention {
	LEFT(1,"left"),RIGHT(2,"right"),UP(3,"up"),DOWN(4,"down");
	public int direction;
	public String directionName;
	private Oriention(int direction,String directionName){
		this.direction=direction;
		this.directionName=directionName;
	}
	@Override
	public String toString(){
		return this.directionName;
	}
	public static Oriention getOriention(int d){
		Oriention temp=LEFT;
		switch(d){
			case 1:
				temp=LEFT;
				break;
			case 2:
				temp= RIGHT;
				break;
			case 3:
				temp= UP;
				break;
			case 4:
				temp= DOWN;
				break;
		}
		return temp;
	}
}
