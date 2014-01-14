package com.joshuaking.entity;

import com.joshuaking.renderer.Sprite;
import com.joshuaking.renderer.SpriteMap;

public class Player extends Entity{

	private static Player instance = null;
	private Player(){
		
		Sprite guy = new Sprite("Assets/Guy.png");
		
		SpriteMap map = new SpriteMap();
		
		map.addAndSetSprite("main", guy);
		
		this.setSprites(map);
		
		
	}
	
	public static Player getInstance(){
		if(instance == null){
			instance = new Player();
		}
		return instance;
	}
}
