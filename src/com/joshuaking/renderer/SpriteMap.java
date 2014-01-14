package com.joshuaking.renderer;

import java.util.HashMap;

public class SpriteMap {

	private HashMap<String, ISprite> sprites;
	private ISprite currSprite;
	public SpriteMap(){
		sprites = new HashMap<String,ISprite>();
		currSprite = null;
	}
	public void addSprite(String name, ISprite sprite){
		if(!sprites.containsKey(name)){
			sprites.put(name, sprite);
		}
	}
	public void setCurrentSprite(String name){
		if(sprites.containsKey(name)){
			currSprite = sprites.get(name);
		}
	}
	public ISprite getCurrentSprite(){
		return currSprite;
	}
	public ISprite getSprite(String name){
		if(sprites.containsKey(name)){
			return sprites.get(name);
		}
		return null;
	}
	
	public void addAndSetSprite(String name, Sprite sprite){
		if(!sprites.containsKey(name)){
			sprites.put(name, sprite);
		}
		this.setCurrentSprite(name);
	}
	public void renderCurrentSprite(float posX, float posY, float rotation){
		this.currSprite.render(posX, posY, rotation);
	}
}
