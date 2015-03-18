package com.gcc2ge.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class AssetLoader implements ApplicationListener {
	private static final String TAG =AssetLoader.class.getName();
	static AssetManager manager;
	public static TiledMap map=null;


	 public static Texture achievements ;
	 public static Texture agent ;
	 public static Texture axe ;
	 public static Texture barsheet ;
	 public static Texture bat ;
	 public static Texture beachnpc ;
	 public static Texture bluesword ;
	 public static Texture border ;
	 public static Texture boss ;
	 public static Texture chest ;
	 public static Texture clotharmor ;
	 public static Texture coder ;
	 public static Texture crab ;
	 public static Texture death ;
	 public static Texture deathknight ;
	 public static Texture desertnpc ;
	 public static Texture eye ;
	 public static Texture firefox ;
	 public static Texture forestnpc ;
	 public static Texture goblin ;
	 public static Texture goldenarmor ;
	 public static Texture goldensword ;
	 public static Texture guard ;
	 public static Texture hand ;
	 public static Texture item_axe ;
	 public static Texture item_bluesword ;
	 public static Texture item_burger ;
	 public static Texture item_cake ;
	 public static Texture item_clotharmor ;
	 public static Texture item_firepotion ;
	 public static Texture item_flask ;
	 public static Texture item_goldenarmor ;
	 public static Texture item_goldensword ;
	 public static Texture item_leatherarmor ;
	 public static Texture item_mailarmor ;
	 public static Texture item_morningstar ;
	 public static Texture item_platearmor ;
	 public static Texture item_redarmor ;
	 public static Texture item_redsword ;
	 public static Texture item_sword1 ;
	 public static Texture item_sword2 ;
	 public static Texture king ;
	 public static Texture lavanpc ;
	 public static Texture leatherarmor ;
	 public static Texture loot ;
	 public static Texture mailarmor ;
	 public static Texture morningstar ;
	 public static Texture nyan ;
	 public static Texture octocat ;
	 public static Texture ogre ;
	 public static Texture platearmor ;
	 public static Texture priest ;
	 public static Texture rat ;
	 public static Texture redarmor ;
	 public static Texture redsword ;
	 public static Texture rick ;
	 public static Texture scientist ;
	 public static Texture shadow16 ;
	 public static Texture skeleton ;
	 public static Texture skeleton2 ;
	 public static Texture snake ;
	 public static Texture sorcerer ;
	 public static Texture sparks ;
	 public static Texture spectre ;
	 public static Texture spritesheet ;
	 public static Texture sword ;
	 public static Texture sword1 ;
	 public static Texture sword2 ;
	 public static Texture talk ;
	 public static Texture target ;
	 public static Texture tilesheet ;
	 public static Texture villagegirl ;
	 public static Texture villager ;
	 public static Texture wizard ;
	 public static Texture wood ;
	 public static Texture wood2 ;
	 public static Texture wood3 ;

	@Override
	public void create() {
		manager = new AssetManager();
		manager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		manager.load("maps/map.tmx", TiledMap.class);
		manager.load("maps/mobset.png", Texture.class);
		manager.load("maps/tilesheet.png", Texture.class);
		//load image
		 manager.load("img/3/achievements.png",Texture.class);
		 manager.load("img/3/agent.png",Texture.class);
		 manager.load("img/3/axe.png",Texture.class);
		 manager.load("img/3/barsheet.png",Texture.class);
		 manager.load("img/3/bat.png",Texture.class);
		 manager.load("img/3/beachnpc.png",Texture.class);
		 manager.load("img/3/bluesword.png",Texture.class);
		 manager.load("img/3/border.png",Texture.class);
		 manager.load("img/3/boss.png",Texture.class);
		 manager.load("img/3/chest.png",Texture.class);
		 manager.load("img/3/clotharmor.png",Texture.class);
		 manager.load("img/3/coder.png",Texture.class);
		 manager.load("img/3/crab.png",Texture.class);
		 manager.load("img/3/death.png",Texture.class);
		 manager.load("img/3/deathknight.png",Texture.class);
		 manager.load("img/3/desertnpc.png",Texture.class);
		 manager.load("img/3/eye.png",Texture.class);
		 manager.load("img/3/firefox.png",Texture.class);
		 manager.load("img/3/forestnpc.png",Texture.class);
		 manager.load("img/3/goblin.png",Texture.class);
		 manager.load("img/3/goldenarmor.png",Texture.class);
		 manager.load("img/3/goldensword.png",Texture.class);
		 manager.load("img/3/guard.png",Texture.class);
		 manager.load("img/3/hand.png",Texture.class);
		 manager.load("img/3/item-axe.png",Texture.class);
		 manager.load("img/3/item-bluesword.png",Texture.class);
		 manager.load("img/3/item-burger.png",Texture.class);
		 manager.load("img/3/item-cake.png",Texture.class);
		 manager.load("img/3/item-clotharmor.png",Texture.class);
		 manager.load("img/3/item-firepotion.png",Texture.class);
		 manager.load("img/3/item-flask.png",Texture.class);
		 manager.load("img/3/item-goldenarmor.png",Texture.class);
		 manager.load("img/3/item-goldensword.png",Texture.class);
		 manager.load("img/3/item-leatherarmor.png",Texture.class);
		 manager.load("img/3/item-mailarmor.png",Texture.class);
		 manager.load("img/3/item-morningstar.png",Texture.class);
		 manager.load("img/3/item-platearmor.png",Texture.class);
		 manager.load("img/3/item-redarmor.png",Texture.class);
		 manager.load("img/3/item-redsword.png",Texture.class);
		 manager.load("img/3/item-sword1.png",Texture.class);
		 manager.load("img/3/item-sword2.png",Texture.class);
		 manager.load("img/3/king.png",Texture.class);
		 manager.load("img/3/lavanpc.png",Texture.class);
		 manager.load("img/3/leatherarmor.png",Texture.class);
		 manager.load("img/3/loot.png",Texture.class);
		 manager.load("img/3/mailarmor.png",Texture.class);
		 manager.load("img/3/morningstar.png",Texture.class);
		 manager.load("img/3/nyan.png",Texture.class);
		 manager.load("img/3/octocat.png",Texture.class);
		 manager.load("img/3/ogre.png",Texture.class);
		 manager.load("img/3/platearmor.png",Texture.class);
		 manager.load("img/3/priest.png",Texture.class);
		 manager.load("img/3/rat.png",Texture.class);
		 manager.load("img/3/redarmor.png",Texture.class);
		 manager.load("img/3/redsword.png",Texture.class);
		 manager.load("img/3/rick.png",Texture.class);
		 manager.load("img/3/scientist.png",Texture.class);
		 manager.load("img/3/shadow16.png",Texture.class);
		 manager.load("img/3/skeleton.png",Texture.class);
		 manager.load("img/3/skeleton2.png",Texture.class);
		 manager.load("img/3/snake.png",Texture.class);
		 manager.load("img/3/sorcerer.png",Texture.class);
		 manager.load("img/3/sparks.png",Texture.class);
		 manager.load("img/3/spectre.png",Texture.class);
		 manager.load("img/3/spritesheet.png",Texture.class);
		 manager.load("img/3/sword.png",Texture.class);
		 manager.load("img/3/sword1.png",Texture.class);
		 manager.load("img/3/sword2.png",Texture.class);
		 manager.load("img/3/talk.png",Texture.class);
		 manager.load("img/3/target.png",Texture.class);
		 manager.load("img/3/tilesheet.png",Texture.class);
		 manager.load("img/3/villagegirl.png",Texture.class);
		 manager.load("img/3/villager.png",Texture.class);
		 manager.load("img/3/wizard.png",Texture.class);
		 manager.load("img/3/wood.png",Texture.class);
		 manager.load("img/3/wood2.png",Texture.class);
		 manager.load("img/3/wood3.png",Texture.class);

		manager.finishLoading();
		Gdx.app.log(TAG, "资源加载完成");
		map=manager.get("maps/map.tmx");
		
		//get
		 achievements= manager.get("img/3/achievements.png");
		 agent= manager.get("img/3/agent.png");
		 axe= manager.get("img/3/axe.png");
		 barsheet= manager.get("img/3/barsheet.png");
		 bat= manager.get("img/3/bat.png");
		 beachnpc= manager.get("img/3/beachnpc.png");
		 bluesword= manager.get("img/3/bluesword.png");
		 border= manager.get("img/3/border.png");
		 boss= manager.get("img/3/boss.png");
		 chest= manager.get("img/3/chest.png");
		 clotharmor= manager.get("img/3/clotharmor.png");
		 coder= manager.get("img/3/coder.png");
		 crab= manager.get("img/3/crab.png");
		 death= manager.get("img/3/death.png");
		 deathknight= manager.get("img/3/deathknight.png");
		 desertnpc= manager.get("img/3/desertnpc.png");
		 eye= manager.get("img/3/eye.png");
		 firefox= manager.get("img/3/firefox.png");
		 forestnpc= manager.get("img/3/forestnpc.png");
		 goblin= manager.get("img/3/goblin.png");
		 goldenarmor= manager.get("img/3/goldenarmor.png");
		 goldensword= manager.get("img/3/goldensword.png");
		 guard= manager.get("img/3/guard.png");
		 hand= manager.get("img/3/hand.png");
		 item_axe= manager.get("img/3/item-axe.png");
		 item_bluesword= manager.get("img/3/item-bluesword.png");
		 item_burger= manager.get("img/3/item-burger.png");
		 item_cake= manager.get("img/3/item-cake.png");
		 item_clotharmor= manager.get("img/3/item-clotharmor.png");
		 item_firepotion= manager.get("img/3/item-firepotion.png");
		 item_flask= manager.get("img/3/item-flask.png");
		 item_goldenarmor= manager.get("img/3/item-goldenarmor.png");
		 item_goldensword= manager.get("img/3/item-goldensword.png");
		 item_leatherarmor= manager.get("img/3/item-leatherarmor.png");
		 item_mailarmor= manager.get("img/3/item-mailarmor.png");
		 item_morningstar= manager.get("img/3/item-morningstar.png");
		 item_platearmor= manager.get("img/3/item-platearmor.png");
		 item_redarmor= manager.get("img/3/item-redarmor.png");
		 item_redsword= manager.get("img/3/item-redsword.png");
		 item_sword1= manager.get("img/3/item-sword1.png");
		 item_sword2= manager.get("img/3/item-sword2.png");
		 king= manager.get("img/3/king.png");
		 lavanpc= manager.get("img/3/lavanpc.png");
		 leatherarmor= manager.get("img/3/leatherarmor.png");
		 loot= manager.get("img/3/loot.png");
		 mailarmor= manager.get("img/3/mailarmor.png");
		 morningstar= manager.get("img/3/morningstar.png");
		 nyan= manager.get("img/3/nyan.png");
		 octocat= manager.get("img/3/octocat.png");
		 ogre= manager.get("img/3/ogre.png");
		 platearmor= manager.get("img/3/platearmor.png");
		 priest= manager.get("img/3/priest.png");
		 rat= manager.get("img/3/rat.png");
		 redarmor= manager.get("img/3/redarmor.png");
		 redsword= manager.get("img/3/redsword.png");
		 rick= manager.get("img/3/rick.png");
		 scientist= manager.get("img/3/scientist.png");
		 shadow16= manager.get("img/3/shadow16.png");
		 skeleton= manager.get("img/3/skeleton.png");
		 skeleton2= manager.get("img/3/skeleton2.png");
		 snake= manager.get("img/3/snake.png");
		 sorcerer= manager.get("img/3/sorcerer.png");
		 sparks= manager.get("img/3/sparks.png");
		 spectre= manager.get("img/3/spectre.png");
		 spritesheet= manager.get("img/3/spritesheet.png");
		 sword= manager.get("img/3/sword.png");
		 sword1= manager.get("img/3/sword1.png");
		 sword2= manager.get("img/3/sword2.png");
		 talk= manager.get("img/3/talk.png");
		 target= manager.get("img/3/target.png");
		 tilesheet= manager.get("img/3/tilesheet.png");
		 villagegirl= manager.get("img/3/villagegirl.png");
		 villager= manager.get("img/3/villager.png");
		 wizard= manager.get("img/3/wizard.png");
		 wood= manager.get("img/3/wood.png");
		 wood2= manager.get("img/3/wood2.png");
		 wood3= manager.get("img/3/wood3.png");

	}
	public static Texture getSprite(String name){
		return manager.get("img/3/"+name+".png");
	}
	@Override
	public void resize(int width, int height) {
		

	}

	@Override
	public void render() {
		

	}

	@Override
	public void pause() {
		

	}

	@Override
	public void resume() {
		

	}

	@Override
	public void dispose() {
		manager.clear();
		manager.dispose();

	}

}
