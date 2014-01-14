package com.joshuaking.board;

import java.util.ArrayList;

import com.joshuaking.renderer.Sprite;
import com.joshuaking.tile.Tile;
import com.joshuaking.tile.TileSet;

public class BoardFactory {

	public final static String TUTORIAL = "tutorial";
	
	public static Board createBoard(String code){
		
		
		
		switch(code){
		case TUTORIAL: return createTutorialBoard();
		
		
		default: return createTutorialBoard();
		}
		
	}
	
	private static Board createTutorialBoard(){
		Board retBoard = new Board();
		
		ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
		
		for(int x=0;x<100;x++){
			ArrayList<Tile> list = new ArrayList<Tile>();
			for(int y=0;y<100;y++){
				if(y==0 || y==99 || x==0 || x==99){
					Tile tile = new Tile(x*32, y*32, true);
					list.add(tile);
				}else{
					Tile tile = new Tile(x*32, y*32, false);
					list.add(tile);
				}
				
			}
			tiles.add(list);
		}
		TileSet tileSet = new TileSet(tiles);
		
		retBoard.setTiles(tileSet);
		
		Sprite bottomLayer = new Sprite("Assets/Map.png");
		
		retBoard.setBottomSprite(bottomLayer);
		
		retBoard.setTopSprite(null);
		
		return retBoard;
		
	}
}
