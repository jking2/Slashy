package com.joshuaking.entity;

public abstract class Projectile extends Entity {

	private boolean isAlive;

	private float velocity;
	
	public abstract boolean increment();
	
	public abstract void collide();
	
	public Projectile(float velocity, float originX, float originY, float radius, float rotation){
		super(originX, originY, radius, rotation);
		this.velocity=velocity;
		this.isAlive=true;
	}
	
	
	
	
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setSpeed(float speed) {
		this.velocity = speed;
	}
}
