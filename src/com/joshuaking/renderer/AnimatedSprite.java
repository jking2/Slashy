package com.joshuaking.renderer;

import java.util.ArrayList;

public class AnimatedSprite {

	public static final float AVERAGE_SPEED = 10;
	
	private ArrayList<Sprite> sprites;

	private int index;

	private float originalSpeed;
	private long lastFrame;
	private float speed;

	public AnimatedSprite(ArrayList<Sprite> sprites, float speed) {
		this.sprites = sprites;
		index = 0;
		this.speed = speed;
		this.originalSpeed = speed;
		lastFrame = System.currentTimeMillis();
	}

	public void resetIndex() {
		index = 0;
	}

	public void resetSpeed() {
		speed = originalSpeed;
	}
	public void setSpeed(float speed){
		this.speed=speed;
	}
	public float getSpeed(){
		return speed;
	}
	public float getOriginalSpeed(){
		return originalSpeed;
	}

	public void resetAll() {
		resetIndex();
		resetSpeed();
	}

	/**
	 * Tells the AnimatedSprite to animate its current sprte in the animation
	 * 
	 * Returns true if the animation ended
	 * 
	 * @param xPos
	 * @param yPos
	 * @param rotation
	 * @return TRUE if animation ended. FALSE if it isn't done
	 */
	public boolean render(float xPos, float yPos, float rotation) {
		sprites.get(index).render(xPos, yPos, rotation);
		if ((System.currentTimeMillis() - lastFrame) > speed * 50) {
			lastFrame = System.currentTimeMillis();
			index++;
			if (index >= sprites.size()) {
				index = 0;
				return true;
			}
		}
		return false;
	}
	
	public void renderFrame(int frame, float xPos, float yPos, float rotation){
		if(frame>=sprites.size()){
			frame = 0;
		}
		sprites.get(frame).render(xPos, yPos, rotation);
	}

}
