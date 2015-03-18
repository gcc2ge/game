package com.gcc2ge.game.groovy

import com.badlogic.gdx.graphics.g2d.Animation;
import com.gcc2ge.game.sprites.Sprite;

import groovy.json.JsonSlurper;
import com.gcc2ge.game.animation.AnimationEntity;

class SpritesJsonParse {
	def sprites=[:]
	def  parseJson(File file){
		def json = new JsonSlurper().parse(new FileReader(file))  
		Sprite sprite=new Sprite()
		sprite.id=json.id
		sprite.width=json.width
		sprite.height=json.height
		sprite.offsetX=json.offset_x==null?0:json.offset_x
		sprite.offsetY=json?.offset_y==null?0:json.offset_y
		def animationMap=[:]
		json.animations.each{
			key,value->
			animationMap[key]=new AnimationEntity(value.length,value.row)
		}
		sprite.animations=animationMap
		sprites[sprite.id]=sprite
	}
	def parseJsons(files){
		files.each {
			parseJson(it)
		}
		sprites
	}
}
