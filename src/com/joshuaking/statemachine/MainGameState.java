package com.joshuaking.statemachine;

import com.joshuaking.board.Board;
import com.joshuaking.board.BoardFactory;
import com.joshuaking.renderer.Render;

public class MainGameState implements IState{

	private Board board;
	
	@Override
	public void update() {
		
		board.update();
		
	}

	@Override
	public void render() {
		board.render();
		
	}

	@Override
	public void enter(String condition) {
		
		Render.getInstance().renderLoadingScreen();
		
		int entryCode = Integer.parseInt(condition.substring(0, 2));
		
		
		String boardCode = condition.substring(2);
		
		board = BoardFactory.createBoard(boardCode);
		board.placePlayer(entryCode);
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	
}
