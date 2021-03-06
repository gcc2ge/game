package com.gcc2ge.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.gcc2ge.game.ai.GridXY;
import com.gcc2ge.game.animation.AnimationConfig;
import com.gcc2ge.game.area.Area;
import com.gcc2ge.game.area.Location;
import com.gcc2ge.game.area.Portal;

public class MapProcess {
	final static String TAG=MapProcess.class.getName();
	TiledMap map;
	Area area;
	public void setArea(Area area){
		this.area=area;
	}
	public MapProcess(TiledMap map){
		this.map=map;
	}
	//animation tile id
	static Map<Integer, AnimationConfig> animationMap=new HashMap<Integer,AnimationConfig>();
	static Array<Integer> highArray=new Array<Integer>();
	static Array<Integer> collideArray=new Array<Integer>();
	
	public void processTileSet(TiledMapTileSet tileSet){
		for(TiledMapTile tile:tileSet){
			//tile id
			int tileId=tile.getId();
			MapProperties properties=tile.getProperties();
			Iterator<String> iterKey=properties.getKeys();
			while(iterKey.hasNext()){
				String key=iterKey.next();
				Object value=properties.get(key);
				
				AnimationConfig animationConfig=null;
				//length 
				if(key.equalsIgnoreCase("length")){
					if(animationMap.containsKey(tileId)){
						animationConfig=animationMap.get(tileId);
					}else{
						animationConfig=new AnimationConfig();
						animationMap.put(tileId, animationConfig);
					}
					animationConfig.id=tileId;
					animationConfig.length=Integer.parseInt(value.toString());
				}else if(key.equalsIgnoreCase("delay")){
					if(animationMap.containsKey(tileId)){
						animationConfig=animationMap.get(tileId);
					}else{
						animationConfig=new AnimationConfig();
						animationMap.put(tileId, animationConfig);
					}
					animationConfig.id=tileId;
					animationConfig.delay=Integer.parseInt(value.toString())*0.001f;
				}else if(key.equalsIgnoreCase("c")){//碰撞
					collideArray.add(tileId);
				}else if(key.equalsIgnoreCase("v")){//深度 
					highArray.add(tileId);
				}
			}
		}
	}
	
	public void processTileSets(){
		for(TiledMapTileSet tileSet:map.getTileSets()){
			processTileSet(tileSet);
		}
	}
	public static HashSet<GridXY> mapCollideArray=new HashSet<GridXY>();
	public void processLayers(){
		for(MapLayer mapLayer:map.getLayers()){
			if (mapLayer.isVisible()) {
				if (mapLayer instanceof TiledMapTileLayer) {
					TiledMapTileLayer layer=(TiledMapTileLayer)mapLayer;
					processLayer(layer);
				} 
			}
		}
		//door
		MapObjects doors=map.getLayers().get("doors").getObjects();
		for(MapObject door:doors){
			MapProperties props=door.getProperties();
			Object x=props.get("x");//GridXY
			Object y=props.get("y");
			//test
			RectangleMapObject rectangleObject=(RectangleMapObject)door;
			Rectangle rectangle=rectangleObject.getRectangle();
			Location fromLocation=new Location(area,new GridXY(rectangle.x/16, rectangle.y/16));
			Portal portal=new Portal();
			int heightTile=314;
			Location targetLocation=new Location(area, new GridXY(Integer.valueOf(x.toString()),heightTile-Integer.valueOf(y.toString())-1));//坐标转换，tileMap object 坐标为左上角 libgdx 坐标为笛卡尔坐标
			portal.setTargetLocation(targetLocation);
			portal.setFromLocation(fromLocation);
			area.addPortal(portal);
			
		}
		Gdx.app.log(TAG,"mapCollideArray size: "+mapCollideArray.size());
	}
	public void processLayer(TiledMapTileLayer layer){
		final int row = layer.getWidth();
		final int col= layer.getHeight();

		
		
		for(int x=0 ;x<row;x++){
			for(int y=0;y<col;y++){
				final TiledMapTileLayer.Cell cell=layer.getCell(x,y);
				if(cell!=null){
					if(collideArray.contains(cell.getTile().getId(), false)){
						GridXY grid=new GridXY(x,y);
						mapCollideArray.add(grid);
					}
				}
			}
		}
		
	}
}
