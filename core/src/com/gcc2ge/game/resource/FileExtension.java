package com.gcc2ge.game.resource;

public enum FileExtension {
	TMX(".tmx",com.badlogic.gdx.maps.tiled.TiledMap.class),PNG(".png",com.badlogic.gdx.graphics.Texture.class);
	private String extension;
	private Class<?> extensionType;
	public Class<?> getExtensionType(){
		return this.extensionType;
	}
	private FileExtension(String extension,Class<?> extensionType){
		this.extension=extension;
		this.extensionType=extensionType;
	}
}
