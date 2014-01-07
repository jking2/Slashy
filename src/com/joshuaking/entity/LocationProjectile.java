package com.joshuaking.entity;

public class LocationProjectile extends Projectile {

	private float destX;
	private float destY;

	public boolean increment() {

		float prevX = this.getPosX();
		float prevY = this.getPosY();

		this.setPosX((float) (this.getPosX() + ((Math.cos(Math.toRadians(this
				.getRotation() - 90))) * getSpeed())));
		this.setPosY((float) (this.getPosY() + ((Math.sin(Math.toRadians(this
				.getRotation() - 90))) * getSpeed())));
		System.out.println(this.getRotation());

		// If heading NW
		if (this.getRotation() < 0 && this.getRotation() >= -90) {
			if (this.getPosX() < destX && destX < prevX) {
				if (this.getPosY() < destY && destY < prevY) {
					this.setAlive(false);
				}
			}
		}
		// If heading NE
		else if (this.getRotation() >= 0 && this.getRotation() < 90) {
			if (this.getPosX() > destX && destX > prevX) {
				if (this.getPosY() < destY && destY < prevY) {
					this.setAlive(false);
				}
			}
		}

		// If heading SW
		else if (this.getRotation() < -90 && this.getRotation() >= -180) {
			if (this.getPosX() < destX && destX < prevX) {
				if (this.getPosY() > destY && destY > prevY) {
					this.setAlive(false);
				}
			}
		}

		// If heading SE
		else if (this.getRotation() < -180 && this.getRotation() >= -270) {
			if (this.getPosX() > destX && destX > prevX) {
				if (this.getPosY() > destY && destY > prevY) {
					this.setAlive(false);
				}
			}
		}

		return this.isAlive();
	}

	public LocationProjectile(float destX, float destY, float speed,
			float originX, float originY, float radius, float rotation) {
		super(speed, originX, originY, radius, rotation);
		this.destX = destX;
		this.destY = destY;
	}

	@Override
	public void collide() {
		// TODO Auto-generated method stub

	}

}
