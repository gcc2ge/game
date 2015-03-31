package com.gcc2ge.game.resource;

public enum ResourceLocation {
	IMG("img"),ANIMATION("animation"),MAP("maps"),SCRIPTS("scripts");
	String location;
	private ResourceLocation(String location){
		this.location=location;
	}
	public @Override String toString(){
		return this.location;
	}
	
}
