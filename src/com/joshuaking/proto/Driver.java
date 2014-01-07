package com.joshuaking.proto;

import java.util.ArrayList;

import com.joshuaking.entity.Projectile;
import com.joshuaking.input.Input;
import com.joshuaking.renderer.Render;
import com.joshuaking.renderer.Sprite;
import com.joshuaking.renderer.SpriteMap;

public class Driver {

	private Sprite guy;
	private Sprite background;
	private float posX = 0;
	private float posY = 0;
	private float rotation = 0;
	private float speed = 0.1f;

	private SpriteMap bullet;
	private ArrayList<Projectile> bullets;

	private boolean freeAim = false;

	public Driver() {
		Render.getInstance().createDisplay();
		guy = new Sprite("Assets/Guy.png");
		background = new Sprite("Assets/Background.png");
		bullet = new SpriteMap();
		bullet.addAndSetSprite("main", new Sprite("Assets/Bullet.png"));
		bullets = new ArrayList<Projectile>();

	}

	public void go() {
		while (true) {

			background.render(0, 0, 0);

			if (Input.getInstance().isMoveUpKeyDown()) {
				posY--;
			} else if (Input.getInstance().isMoveDownKeyDown()) {
				posY++;
			}
			if (Input.getInstance().isMoveLeftKeyDown()) {
				posX--;
			} else if (Input.getInstance().isMoveRightKeyDown()) {
				posX++;
			}
			if (Input.getInstance().isActionKeyOneDown()) {
				freeAim = true;
			}
			if (Input.getInstance().isActionKeyTwoDown()) {
				freeAim = false;
			}

			if (freeAim) {
				if (Input.getInstance().isMoveUpKeyDown()) {
					posY--;
				} else if (Input.getInstance().isMoveDownKeyDown()) {
					posY++;
				}
				if (Input.getInstance().isMoveLeftKeyDown()) {
					posX--;
				} else if (Input.getInstance().isMoveRightKeyDown()) {
					posX++;
				}

				double r = Math.atan2(posY
						- Input.getInstance().getMouseVector().getY(), posX
						- Input.getInstance().getMouseVector().getX());
				double d = 57.2957795f * r;

				rotation = (float) (d - 90);
			} else {

				boolean up = false;
				boolean down = false;
				if (Input.getInstance().isMoveUpKeyDown()) {
					posY--;
					rotation = 0;
					up = true;
				} else if (Input.getInstance().isMoveDownKeyDown()) {
					posY++;
					rotation = 180;
					down = true;
				}
				if (Input.getInstance().isMoveLeftKeyDown()) {
					posX--;
					rotation = -90;
					if (up) {
						rotation = -45;
					}
					if (down) {
						rotation = -135;
					}
				} else if (Input.getInstance().isMoveRightKeyDown()) {
					posX++;
					rotation = 90;
					if (up) {
						rotation = 45;
					}
					if (down) {
						rotation = 135;
					}
				}
			}

			if (Input.getInstance().isMouseLeftClick()) {
				Projectile newP = new Projectile(Input.getInstance()
						.getMouseVector().getX(), Input.getInstance()
						.getMouseVector().getY(), 8, posX, posY, 3, rotation);
				newP.setSprites(bullet);
				bullets.add(newP);
			}
			for (Projectile cur : bullets) {
				cur.increment();
				cur.getSprites().renderCurrentSprite(cur.getPosX(),
						cur.getPosY(), cur.getRotation());
			}
			guy.render(posX, posY, rotation);
			Render.getInstance().updateDisplay();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		Driver d = new Driver();
		d.go();
	}
}
