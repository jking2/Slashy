package com.joshuaking.map;

import java.util.ArrayList;

public class TileSet {

	private ArrayList<ArrayList<Tile>> tiles;
	
	public TileSet(ArrayList<ArrayList<Tile>> tiles){
		this.tiles=tiles;
	}
	
	public Tile getTile(int x, int y){
		return tiles.get(y).get(x);
	}
	
}
