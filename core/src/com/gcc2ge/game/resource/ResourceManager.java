package com.gcc2ge.game.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.files.FileHandle;

public class ResourceManager {
	private static List<ResourcePackage> resources=new ArrayList<ResourcePackage>();
	//½Å±¾»º´æ
	private static Map<String, String> cachedFiles = new HashMap<String, String>();
	
	public static void registerDesktopResource(){
		if (Gdx.app.getType() == ApplicationType.Android) {
			resources.add(new AndroidResource());
		} else {
			resources.add(new DeskResource());
		}
	}
	public static Set<String> getResourceInDirectory(String dir){		
		Set<String> set = new LinkedHashSet<String>();
		for(ResourcePackage resourcePackage:resources){
			Set<String> tempSet=resourcePackage.getResourcesIn(dir);
			if(tempSet!=null){
				set.addAll(tempSet);
			}
		}
		return set;
	}
	public static boolean hasResource(String resource){
		for(ResourcePackage rpackage:resources){
			if(rpackage.hasResource(resource)){
				return true;
			}
		}
		return false;
	}
	public static Set<String> getResourceInDirectoryByType(String dir,ResourceType type){		
		Set<String> set = new LinkedHashSet<String>();
		for(ResourcePackage resourcePackage:resources){
			Set<String> tempSet=resourcePackage.getResourcesIn(dir);
			if(tempSet!=null){
				for(String path:tempSet){
					if(path.endsWith(type.toString())){
						set.add(path);
					}
				}
			}
		}
		return set;
	}
	public static FileHandle getResourceAsFileHandle(String resource){
		for(ResourcePackage rpackage:resources){
			if(rpackage.hasResource(resource)){
				return rpackage.getFileHandle(resource);
			}
		}
		return null;
	}
	public static String getResourceName(String resource){
		FileHandle file=getResourceAsFileHandle(resource);
		if(file!=null){
			return file.name();
		}
		return null;
	}
	public static String getResourceAsString(String resource){
		if(cachedFiles.containsKey(resource)){
			return cachedFiles.get(resource);
		}
		FileHandle handle=null;
		for(ResourcePackage rpackage:resources){
			if(rpackage.hasResource(resource)){
				handle= rpackage.getFileHandle(resource);
				break;
			}
		}
		if(handle!=null){
			cachedFiles.put(resource, handle.readString());
			return cachedFiles.get(resource);
		}
		return null;
	}
}
