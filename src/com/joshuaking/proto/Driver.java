package com.joshuaking.proto;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;

import com.joshuaking.entity.Projectile;
import com.joshuaking.input.Input;
import com.joshuaking.map.Tile;
import com.joshuaking.map.TileSet;
import com.joshuaking.renderer.Render;
import com.joshuaking.renderer.Sprite;
import com.joshuaking.renderer.SpriteMap;

public class Driver {

	private Sprite guy;
	private Sprite background;
	private float posX = -64;
	private float posY = -64;
	private float rotation = 0;
	private float speed = 0.1f;

	private TileSet tileSet;
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

		genTiles();
	}

	public void go() {
		while (true) {

			background.render(0, 0, 0);

			float prevX = posX;
			float prevY = posY;
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
			
			Rectangle me = new Rectangle(posX-32, posY-32, 64, 64);
			
			if(tileSet.isCollision(me)){
				posX =prevX;
				posY =prevY;
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
			tileSet.render();
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
	private void genTiles(){
		
		ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
		
		Sprite tileSprite = new Sprite("Assets/Tile.png");
		System.out.println("genning tiles");
		for(int x=0;x<10;x++){
			ArrayList<Tile> list = new ArrayList<Tile>();
			for(int y=0;y<10;y++){
				Tile tile = new Tile(x*64, y*64, true, tileSprite);
				list.add(tile);
			}
			tiles.add(list);
		}
		tileSet = new TileSet(tiles);
	}
}
