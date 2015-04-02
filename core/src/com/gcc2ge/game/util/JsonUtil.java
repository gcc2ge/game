package com.gcc2ge.game.util;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class JsonUtil {
	static JsonReader reader=new JsonReader();
	public static JsonValue parse(String json){
		return reader.parse(json);
	}
	public static JsonValue parse(FileHandle file){
		return reader.parse(file);
	}
}
