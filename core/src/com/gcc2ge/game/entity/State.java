package com.gcc2ge.game.entity;

public enum State {
	ATTACK("atk"),WALK("walk"),IDLE("idle"),DEATH("death");
	
	private String state;
	
	private State(String s){
		this.state=s;
	}
	@Override
	public String toString(){
		return this.state;
	}
}
