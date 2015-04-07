package com.gcc2ge.game.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class AndroidResource extends ResourcePackage {
	private final String prefix="";
	public AndroidResource(){
		for(ResourceLocation location:ResourceLocation.values()){
			file(location.toString());
		}
	}
	public void addFile(String path){
		if(path.indexOf(prefix)!=-1){
			this.addResource(path.substring(prefix.length()));
		}else{
			this.addResource(path);
		}
	}
	public void file(String root){
		FileHandle dirHandle= Gdx.files.internal(root);
		for(FileHandle filehandle:dirHandle.list()){
			if(filehandle.isDirectory()){
				file(filehandle.path());
			}else{
				addFile(filehandle.path());
			}
		}
		if(!dirHandle.isDirectory()){
			addFile(dirHandle.path());
		}
	}
	@Override
	public FileHandle getFileHandle(String resource) {
		return Gdx.files.internal(resource);
	}
	
}
