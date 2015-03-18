package com.gcc2ge.game.ai;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MoveTest {
	AStar aStar;
	public void moveTo(int x,int y){
		
	}
	public void render(ShapeRenderer shapeRender){
		shapeRender.begin(ShapeType.Filled);
		// set to green for full mob health
		shapeRender.setColor(0, 255, 0, 1);
//		shapeRender.circle(x, y, radius)
		shapeRender.end();
	}
}
