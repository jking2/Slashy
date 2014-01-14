package com.joshuaking.tile;

import org.newdawn.slick.geom.Rectangle;

import com.joshuaking.IAObject.IAObject;
import com.joshuaking.renderer.Sprite;

public class Tile {

	public static float TILE_RADIUS = 32;
	private boolean isSolid;
	private Rectangle hitbox;
	private float posX;
	private float posY;
	private IAObject object;
	
	public Tile(float posX, float posY, boolean isSolid){
		this.posX=posX;
		this.posY=posY;
		this.isSolid=isSolid;
		calcHitbox();
	}
	private void calcHitbox(){
		hitbox = new Rectangle(posX-(TILE_RADIUS/2), posY-(TILE_RADIUS/2), TILE_RADIUS, TILE_RADIUS);
	}
	public boolean isSolid() {
		return isSolid;
	}
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	public float getPosX() {
		return posX;
	}
	public void setPosX(float posX) {
		this.posX = posX;
	}
	public float getPosY() {
		return posY;
	}
	public void setPosY(float posY) {
		this.posY = posY;
	}
	public Rectangle getHitbox() {
		return hitbox;
	}
	public IAObject getObject() {
		return object;
	}
	public void setObject(IAObject object) {
		this.object = object;
	}
	public void renderObject(){
		
	}
}
