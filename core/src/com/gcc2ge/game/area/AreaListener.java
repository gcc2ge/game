package com.gcc2ge.game.area;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Pixmap;

public class AreaListener implements InputProcessor{

	@Override
	public boolean keyDown(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		//转换坐标
		
//		Pixmap p=new Pixmap(Gdx.files.internal("img/mouse/hand.png"));
//		Gdx.input.setCursorImage(p, 0, 0);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}
	public void computeMouseState(){
		
	}
}
