package com.gcc2ge.game;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gcc2ge.game.animation.AnimationConfig;
import com.gcc2ge.game.animation.AnimationTile;

/**
 * 
 * @author Administrator
 *	OrthogonalTiledMapRenderer 的代理类
 */
public class TileMapRender {
	OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
	Rectangle viewBounds=null;
	TiledMap map=null;
	SpriteBatch batch;
	Map<Cell,AnimationTile> animationMap=new HashMap<Cell, AnimationTile>();
	TileRender animationTileRender=new TileRender() {
		
		@Override
		public void render(TiledMapTileLayer.Cell cell,float x,float y,SpriteBatch batch) {
			AnimationTile animationTile;
			AnimationConfig animationConfig;
			if(MapProcess.animationMap.containsKey(cell.getTile().getId())){
				animationConfig=MapProcess.animationMap.get(cell.getTile().getId());
				if(animationMap.containsKey(cell)){
					animationTile=animationMap.get(cell);
				}else{
					animationTile=new AnimationTile(x, y, animationConfig.delay, animationConfig.id,animationConfig.length,map);
					animationMap.put(cell, animationTile);
				}
				animationTile.tick();
				animationTile.render(batch);
			}
			
		}
	};
	TileRender highTileRender=new TileRender() {
		
		@Override
		public void render(Cell cell, float x, float y, SpriteBatch batch) {
			if(MapProcess.highArray.contains(cell.getTile().getId(), false)){
				batch.draw(cell.getTile().getTextureRegion(), x, y);
			}
			
		}
	};
	public TileMapRender (TiledMap map, SpriteBatch batch) {
		orthogonalTiledMapRenderer=new OrthogonalTiledMapRenderer(map,batch);
		this.map=map;
		this.batch=(SpriteBatch) batch;
	}
	public void render(){
		orthogonalTiledMapRenderer.render();
		//
		viewBounds=orthogonalTiledMapRenderer.getViewBounds();
		batch.begin();
		for (MapLayer layer : map.getLayers()) {
			if (layer.isVisible()) {
				if (layer instanceof TiledMapTileLayer) {
					renderTileLayer((TiledMapTileLayer)layer,animationTileRender);
				} 
			}
		}
		for (MapLayer layer : map.getLayers()) {
			if (layer.isVisible()) {
				if (layer instanceof TiledMapTileLayer) {
					renderTileLayer((TiledMapTileLayer)layer,highTileRender);
				} 
			}
		}
		batch.end();
		
		
	}
	public void setView(OrthographicCamera camera){
		orthogonalTiledMapRenderer.setView(camera);
	}
	public void render(int[] layers){
		orthogonalTiledMapRenderer.render(layers);
	}
	public void renderTileAnimation(TiledMapTileLayer layer){
		
	}
	public void renderTileHigh(){
		//
		viewBounds=orthogonalTiledMapRenderer.getViewBounds();
		batch.begin();
		for (MapLayer layer : map.getLayers()) {
			if (layer.isVisible()) {
				if (layer instanceof TiledMapTileLayer) {
					renderTileLayer((TiledMapTileLayer)layer,highTileRender);
				} 
			}
		}
		batch.end();
	}
	//
	public void renderTileLayer (TiledMapTileLayer layer,TileRender tileRender) {
		final int layerWidth = layer.getWidth();
		final int layerHeight = layer.getHeight();

		final float layerTileWidth = layer.getTileWidth() ;
		final float layerTileHeight = layer.getTileHeight() ;

		final int col1 = Math.max(0, (int)(viewBounds.x / layerTileWidth));
		final int col2 = Math.min(layerWidth, (int)((viewBounds.x + viewBounds.width + layerTileWidth) / layerTileWidth));

		final int row1 = Math.max(0, (int)(viewBounds.y / layerTileHeight));
		final int row2 = Math.min(layerHeight, (int)((viewBounds.y + viewBounds.height + layerTileHeight) / layerTileHeight));

		float y = row2 * layerTileHeight;
		float xStart = col1 * layerTileWidth;

		for (int row = row2; row >= row1; row--) {
			float x = xStart;
			for (int col = col1; col < col2; col++) {
				final TiledMapTileLayer.Cell cell = layer.getCell(col, row);
				if (cell == null) {
					x += layerTileWidth;
					continue;
				}
				///-------------------
				tileRender.render(cell, x, y, batch);
				///-------------------
				x += layerTileWidth;
			}
			y -= layerTileHeight;
		}
	}
	
	interface TileRender{
		public void render(TiledMapTileLayer.Cell cell,float x,float y,SpriteBatch batch);
	}
}
