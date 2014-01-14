package com.joshuaking.board;

import java.util.ArrayList;

import com.joshuaking.entity.Entity;
import com.joshuaking.entity.Player;
import com.joshuaking.entity.Projectile;
import com.joshuaking.input.Input;
import com.joshuaking.renderer.Sprite;
import com.joshuaking.tile.TileSet;

public class Board {

	private TileSet tiles;

	private ArrayList<Entity> NPCs;

	private ArrayList<Projectile> projectiles;

	private Sprite bottomSprite;

	private Sprite topSprite;

	public Board() {
		NPCs = new ArrayList<Entity>();
		projectiles = new ArrayList<Projectile>();
	}

	protected void setTiles(TileSet tiles) {
		this.tiles = tiles;
	}

	public void placePlayer(int entryCode) {
		switch (entryCode) {
		case 0:
			Player.getInstance().setPosX(10);
			Player.getInstance().setPosY(10);
			return;
		case 1:
			Player.getInstance().setPosX(200);
			Player.getInstance().setPosY(200);
			return;

		default:
			Player.getInstance().setPosX(10);
			Player.getInstance().setPosY(10);
			return;
		}
	}

	// ****************************************
	// ////UPDATES
	// //**************************************
	public void update() {

		getInput();
		Player.getInstance().update();
		boardUpdate();
	}

	public void render() {
		renderMain();
		Player.getInstance().render();
		renderTop();
	}
	
	private void getInput(){
		
		float prevX = Player.getInstance().getPosX();
		float prevY = Player.getInstance().getPosY();
		
		if (Input.getInstance().isMoveUpKeyDown()) {
			Player.getInstance().decPosY();
		} else if (Input.getInstance().isMoveDownKeyDown()) {
			Player.getInstance().incPosY();
		}
		if (Input.getInstance().isMoveLeftKeyDown()) {
			Player.getInstance().decPosX();
		} else if (Input.getInstance().isMoveRightKeyDown()) {
			Player.getInstance().incPosX();
		}
		
		double r = Math.atan2(Player.getInstance().getPosY()
				- Input.getInstance().getMouseVector().getY(), Player.getInstance().getPosX()
				- Input.getInstance().getMouseVector().getX());
		double d = 57.2957795f * r;

		Player.getInstance().setRotation((float) (d - 90));
		
	}

	private void boardUpdate() {

	}
	

	private void renderMain() {
		bottomSprite.render(0, 0, 0);
	}

	private void renderTop() {
		if (topSprite != null) {
			topSprite.render(0, 0, 0);
		}
	}

	protected void setBottomSprite(Sprite bottomSprite) {
		this.bottomSprite = bottomSprite;
	}

	protected void setTopSprite(Sprite topSprite) {
		this.topSprite = topSprite;
	}
}
