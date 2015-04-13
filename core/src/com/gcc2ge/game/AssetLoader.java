package com.gcc2ge.game;

import java.util.LinkedHashSet;
import java.util.Set;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.gcc2ge.game.resource.FileExtension;
import com.gcc2ge.game.resource.ResourceLocation;
import com.gcc2ge.game.resource.ResourceManager;
import com.gcc2ge.game.resource.ResourceType;
import com.gcc2ge.game.sprites.SpriteManager;

public class AssetLoader implements ApplicationListener {
	private static final String TAG =AssetLoader.class.getName();
	static AssetManager manager;
	public static TiledMap map=null;

	public String getExtendsion(String path){
		return path.substring(path.indexOf(".")+1).toUpperCase();
	}

	@Override
	public void create() {
		
		manager = new AssetManager();
		manager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		
		//load image
	   for(ResourceLocation location:ResourceLocation.values()){
		   Set<String> sortedSet=new LinkedHashSet<String>();
		   sortedSet.addAll(ResourceManager.getResourceInDirectoryByType(location.toString(),ResourceType.PNG));
		   sortedSet.addAll(ResourceManager.getResourceInDirectoryByType(location.toString(),ResourceType.TMX));
		   if(sortedSet.size()==0)continue;
		   for(String resource:sortedSet){
			   manager.load(resource, FileExtension.valueOf(getExtendsion(resource)).getExtensionType());
		   }
	   }
		manager.finishLoading();
		Gdx.app.log(TAG, "资源加载完成");
		map=manager.get("maps/map.tmx");
		//get
		Set<String> mouse=ResourceManager.getResourceInDirectoryByType("img", ResourceType.PNG);
		for(String s:mouse){
			Texture t=manager.get(s);
			SpriteManager.addTexture(s, t);
		}

	}
	@Override
	public void resize(int width, int height) {
		

	}

	@Override
	public void render() {
		

	}

	@Override
	public void pause() {
		

	}

	@Override
	public void resume() {
		

	}

	@Override
	public void dispose() {
		manager.clear();
		manager.dispose();

	}

}
