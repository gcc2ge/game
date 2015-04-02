package com.gcc2ge.game.resource;

public enum ResourceType {
	PNG(".png"),
	JavaScript(".js"),
	JSON(".json"),
	TMX(".tmx"),
	;
	private String extension;
	private final int length;
	private ResourceType(String extension){
		this.extension=extension;
		this.length=extension.length();
	}
	@Override public String toString(){
		return this.extension;
	}
	public int getLength(){
		return this.length;
	}
}
