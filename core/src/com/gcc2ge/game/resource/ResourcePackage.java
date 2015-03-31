package com.gcc2ge.game.resource;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * ʹ��libgdx �Դ���file������Դ
 * @author Administrator
 *
 */
public class ResourcePackage {
	public final TreeSet<String > entries;
	public ResourcePackage(){
		this.entries=new TreeSet<String>();
	}
	public void removeResource(String path){
		entries.remove(path);
	}
	public void addResource(String path){
		entries.add(path);
	}
	public SortedSet<String> getResourcesIn(String directory){
		String first=entries.ceiling(directory+"/");
		String last=entries.ceiling(directory+Character.MAX_VALUE);
		if(first==null)
			return null;
		if(last==null)
			return entries.tailSet(first);
		return entries.subSet(first, last);
	}
	public boolean hasResource(String path){
		return entries.contains(path);
	}
	
}
