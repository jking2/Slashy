package com.joshuaking.tile;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;

public class TileSet {

	private ArrayList<ArrayList<Tile>> tiles;
	
	public TileSet(ArrayList<ArrayList<Tile>> tiles){
		this.tiles=tiles;
	}
	
	public Tile getTile(int x, int y){
		return tiles.get(y).get(x);
	}
	public void render(){
		for(ArrayList<Tile> list : tiles){
			for(Tile tile : list){
				tile.renderObject();
			}
		}
	}
	
	public boolean isCollision(Rectangle check){
		
		for(ArrayList<Tile> list : tiles){
			for(Tile tile : list){
				if(tile.isSolid()){
					if(tile.getHitbox().intersects(check)){
						return true;
					}
				}
			}
		}
		return false;
	}
}
