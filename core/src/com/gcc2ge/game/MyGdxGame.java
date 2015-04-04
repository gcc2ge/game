package com.gcc2ge.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gcc2ge.game.resource.ResourceManager;
import com.gcc2ge.game.script.GroovyScriptEngineManager;
import com.gcc2ge.game.script.ScriptInterface;
import com.gcc2ge.game.sprites.SpriteManager;
import com.gcc2ge.game.srceen.GameScreen;

public class MyGdxGame extends Game {
	public static ScriptInterface scriptInterface;
	public static GroovyScriptEngineManager scriptEngineManager;
	public static SpriteManager spriteManager;
	public static AssetLoader loader=null;
	private void init(){
		ResourceManager.registerDesktopResource();
		loader=new AssetLoader();
		loader.create();
		this.scriptEngineManager=new GroovyScriptEngineManager();
		this.scriptInterface=new ScriptInterface();
		this.spriteManager = new SpriteManager();//加载动画 和 粒子
		this.spriteManager.loadResource();
	}
	@Override
	public void create() {
		//初始化资源
		init();
		Gdx.app.setLogLevel(Application.LOG_NONE);//开关日志
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
