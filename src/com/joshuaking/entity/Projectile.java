package com.joshuaking.entity;

public  class Projectile extends Entity{

	private float destX;
	private float destY;
	
	private float speed;
	
	
	public void increment(){

		this.setPosX((float) (this.getPosX()+((Math.cos(Math.toRadians(this.getRotation()-90)))*speed)));
		this.setPosY((float) (this.getPosY()+((Math.sin(Math.toRadians(this.getRotation()-90)))*speed)));
	}
	
	public Projectile(float destX, float destY, float speed, float originX, float originY, float radius, float rotation){
		super(originX, originY,radius, rotation);
		this.destX=destX;
		this.destY=destY;
		this.speed=speed;
		
	}
	
}
