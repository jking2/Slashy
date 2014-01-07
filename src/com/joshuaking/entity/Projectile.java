package com.joshuaking.entity;

public abstract class Projectile extends Entity {

	private boolean isAlive;

	private float speed;
	
	public abstract boolean increment();
	
	public abstract void collide();
	
	public Projectile(float speed, float originX, float originY, float radius, float rotation){
		super(originX, originY, radius, rotation);
		this.speed=speed;
		this.isAlive=true;
	}
	
	
	
	
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
