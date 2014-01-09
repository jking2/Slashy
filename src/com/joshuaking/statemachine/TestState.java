package com.joshuaking.statemachine;

import java.util.ArrayList;

import com.joshuaking.input.Input;
import com.joshuaking.main.MainGame;
import com.joshuaking.renderer.AnimatedSprite;
import com.joshuaking.renderer.Sprite;

public class TestState implements IState {

	private AnimatedSprite sprite;
	private boolean done;

	@Override
	public void update() {
		if (Input.getInstance().isConfirmKeyDown()) {
			done = false;
		}
	}

	@Override
	public void render() {
		if (done == true) {
			sprite.renderFrame(0, 0, 0, 0);
		} else if (sprite.render(0, 0, 0)) {
			done = true;
		}
	}

	@Override
	public void enter(String condition) {
		System.out.println("ENTERING");
		Sprite one = new Sprite("Assets/One.png");
		Sprite two = new Sprite("Assets/Two.png");
		Sprite three = new Sprite("Assets/Three.png");
		Sprite four = new Sprite("Assets/Four.png");
		ArrayList<Sprite> addme = new ArrayList<Sprite>();
		addme.add(one);
		addme.add(two);
		addme.add(three);
		addme.add(four);
		sprite = new AnimatedSprite(addme, 10);
		done = false;
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}
