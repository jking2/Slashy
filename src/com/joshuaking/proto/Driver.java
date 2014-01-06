package com.joshuaking.proto;

import com.joshuaking.input.Input;
import com.joshuaking.renderer.Render;
import com.joshuaking.renderer.Sprite;

public class Driver {

	
	private Sprite guy;
	private Sprite background;
	private double posX =0;
	private double posY =0;
	private double rotation = 0;
	private double speed = 0.1;
	
	private boolean freeAim = false;
	
	public Driver(){
		Render.getInstance().createDisplay();
		guy = new Sprite("Assets/Guy.png");
		background = new Sprite("Assets/Background.png");
	}
	
	public void go(){
		while(true){

			background.render(0, 0,0);
			
			if(Input.getInstance().isMoveUpKeyDown()){
				posY--;
			}else if(Input.getInstance().isMoveDownKeyDown()){
				posY++;
			}
			if(Input.getInstance().isMoveLeftKeyDown()){
				posX--;
			}else if(Input.getInstance().isMoveRightKeyDown()){
				posX++;
			}
			if(Input.getInstance().isActionKeyOneDown()){
				freeAim=true;
			}
			if(Input.getInstance().isActionKeyTwoDown()){
				freeAim=false;
			}
			
			if(freeAim){
				if(Input.getInstance().isMoveUpKeyDown()){
					posY--;
				}else if(Input.getInstance().isMoveDownKeyDown()){
					posY++;
				}
				if(Input.getInstance().isMoveLeftKeyDown()){
					posX--;
				}else if(Input.getInstance().isMoveRightKeyDown()){
					posX++;
				}
			
			double r = Math.atan2(posY - Input.getInstance().getMouseVector().getY(), posX - Input.getInstance().getMouseVector().getX());
			double d = 57.2957795f*r;
			
			rotation = d-90;
			}else{
				
				boolean up = false;
				boolean down = false;
				if(Input.getInstance().isMoveUpKeyDown()){
					posY--;
					rotation=0;
					up =true;
				}else if(Input.getInstance().isMoveDownKeyDown()){
					posY++;
					rotation=180;
					down = true;
				}
				if(Input.getInstance().isMoveLeftKeyDown()){
					posX--;
					rotation=-90;
					if(up){
						rotation=-45;
					}if(down){
						rotation=-135;
					}
				}else if(Input.getInstance().isMoveRightKeyDown()){
					posX++;
					rotation=90;
					if(up){
						rotation=45;
					}if(down){
						rotation=135;
					}
				}
			}
			
			
			
			guy.render(posX, posY,rotation);
			Render.getInstance().updateDisplay();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]){
		Driver d = new Driver();
		d.go();
	}
}
