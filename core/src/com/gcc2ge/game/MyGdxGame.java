package com.gcc2ge.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gcc2ge.game.script.GroovyScriptEngineManager;
import com.gcc2ge.game.script.ScriptInterface;
import com.gcc2ge.game.srceen.GameScreen;

public class MyGdxGame extends Game {
	public static ScriptInterface scriptInterface;
	public static GroovyScriptEngineManager scriptEngineManager;
	private void init(){
		this.scriptEngineManager=new GroovyScriptEngineManager();
		this.scriptInterface=new ScriptInterface();
	}
	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_NONE);
		setScreen(new GameScreen(this));;
	}

	@Override
	public void dispose() {
		
		super.dispose();
	}

	@Override
	public void pause() {
		
		super.pause();
	}

	@Override
	public void resume() {
		
		super.resume();
	}

	@Override
	public void render() {
		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		
		super.resize(width, height);
	}

	@Override
	public void setScreen(Screen screen) {
		
		super.setScreen(screen);
	}

	@Override
	public Screen getScreen() {
		
		return super.getScreen();
	}
	
}
