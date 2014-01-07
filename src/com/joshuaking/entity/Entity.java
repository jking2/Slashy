package com.joshuaking.entity;


import org.newdawn.slick.geom.Rectangle;

import com.joshuaking.renderer.SpriteMap;

public class Entity {

	private SpriteMap sprites;
	private float posX;
	private float posY;
	private float radius;
	private float rotation;
	private Rectangle hitbox;
	
	public Entity(){
		sprites = null;
		posX = 0;
		posY =0;
		radius = 0;
		hitbox = null;
	}
	public Entity(SpriteMap sprites){
		this.sprites=sprites;
		posX=0;
		posY=0;
		rotation=0;
		radius=0;
		hitbox = null;
	}
	
	public Entity(SpriteMap sprites, float posX, float posY, float radius, float rotation){
		this.sprites=sprites;
		this.posX=posX;
		this.posY=posY;
		this.radius=radius;
		this.rotation=rotation;
		calcHitbox();
	}
	public Entity(float posX, float posY, float radius, float rotation){
		this.sprites=null;
		this.posX=posX;
		this.posY=posY;
		this.radius=radius;
		this.rotation=rotation;
		calcHitbox();
	}
	
	public SpriteMap getSprites() {
		return sprites;
	}
	public void setSprites(SpriteMap sprites) {
		this.sprites = sprites;
	}
	public float getPosX() {
		return posX;
	}
	public void setPosX(float posX) {
		this.posX = posX;
		calcHitbox();
	}
	public float getPosY() {
		return posY;
	}
	public void setPosY(float posY) {
		this.posY = posY;
		calcHitbox();
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
		calcHitbox();
	}
	public float getRotation() {
		return rotation;
	}
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	public Rectangle getHitbox(){
		return hitbox;
	}
	private void calcHitbox(){
		hitbox = new Rectangle(posX, posY, radius, radius);
	}
}
