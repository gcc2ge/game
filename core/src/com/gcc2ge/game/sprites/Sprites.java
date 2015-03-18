package com.gcc2ge.game.sprites;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import com.gcc2ge.game.groovy.SpritesJsonParse;


public class Sprites {
	private  String[] resourses={
				"sprites/agent.json",
		        "sprites/arrow.json",
		        "sprites/axe.json",
		        "sprites/bat.json",
		        "sprites/beachnpc.json",
		        "sprites/bluesword.json",
		        "sprites/boss.json",
		        "sprites/chest.json",
		        "sprites/clotharmor.json",
		        "sprites/coder.json",
		        "sprites/crab.json",
		        "sprites/death.json",
		        "sprites/deathknight.json",
		        "sprites/desertnpc.json",
		        "sprites/eye.json",
		        "sprites/firefox.json",
		        "sprites/forestnpc.json",
		        "sprites/goblin.json",
		        "sprites/goldenarmor.json",
		        "sprites/goldensword.json",
		        "sprites/guard.json",
		        "sprites/hand.json",
		        "sprites/impact.json",
		        "sprites/item-axe.json",
		        "sprites/item-bluesword.json",
		        "sprites/item-burger.json",
		        "sprites/item-cake.json",
		        "sprites/item-firepotion.json",
		        "sprites/item-flask.json",
		        "sprites/item-goldenarmor.json",
		        "sprites/item-goldensword.json",
		        "sprites/item-leatherarmor.json",
		        "sprites/item-mailarmor.json",
		        "sprites/item-morningstar.json",
		        "sprites/item-platearmor.json",
		        "sprites/item-redarmor.json",
		        "sprites/item-redsword.json",
		        "sprites/item-sword1.json",
		        "sprites/item-sword2.json",
		        "sprites/king.json",
		        "sprites/lavanpc.json",
		        "sprites/leatherarmor.json",
		        "sprites/loot.json",
		        "sprites/mailarmor.json",
		        "sprites/morningstar.json",
		        "sprites/nyan.json",
		        "sprites/octocat.json",
		        "sprites/ogre.json",
		        "sprites/platearmor.json",
		        "sprites/priest.json",
		        "sprites/rat.json",
		        "sprites/redarmor.json",
		        "sprites/redsword.json",
		        "sprites/rick.json",
		        "sprites/scientist.json",
		        "sprites/shadow16.json",
		        "sprites/skeleton.json",
		        "sprites/skeleton2.json",
		        "sprites/snake.json",
		        "sprites/sorcerer.json",
		        "sprites/sparks.json",
		        "sprites/spectre.json",
		        "sprites/sword.json",
		        "sprites/sword1.json",
		        "sprites/sword2.json",
		        "sprites/talk.json",
		        "sprites/target.json",
		        "sprites/villagegirl.json",
		        "sprites/villager.json",
		        "sprites/wizard.json"
	};
	private  List<File> files=new ArrayList<File>();
	private  HashMap<String,Sprite> spriteMap=null;
	public static Sprites instance=new Sprites();
	private Sprites(){
		load();
	}
	public  void load() {
		for(String resourse:resourses){
			URL url=Sprites.class.getClassLoader().getResource(resourse);
			files.add(new File(url.getFile()));
			
		}
//		spriteMap=(HashMap<String,Sprite>) new SpritesJsonParse().parseJsons(files);
	}
	
	public Sprite createSprite(String name){
		if(spriteMap.get(name)!=null){
			return spriteMap.get(name);
		}
		return null;
	}
}
