package com.gcc2ge.game.resource;

public enum ResourceLocation {
	IMG("img"),ANIMATION("animation"),MAP("maps");
	String location;
	private ResourceLocation(String location){
		this.location=location;
	}
	public @Override String toString(){
		return this.location;
	}
	
}
