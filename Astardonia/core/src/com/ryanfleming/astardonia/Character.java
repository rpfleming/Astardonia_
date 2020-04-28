package com.ryanfleming.astardonia;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Character {
	SpriteBatch batch;
	Texture characterIdleRight = new Texture("Character.png");
	Sprite charSprite;
	int width = 30, height = 30;
	int x, y;
	checkCollision collide;
	GeneratePlanet planet;
	boolean LR = false;
	boolean UD = false;
	
	public Character(GeneratePlanet planet, int x, int y) {
		this.planet = planet;
		batch = new SpriteBatch();
		charSprite = new Sprite(characterIdleRight);
		charSprite.setSize(width, height);
		this.x = x;
		this.y = y;
		charSprite.setX(x);
		charSprite.setY(y);
		collide = new checkCollision(planet);
	}
	
	public void handleMovement(GeneratePlanet planet){
		this.planet = planet;
		
		moveLeft();
		moveRight();
		moveBottom();
		
		if(y < (planet.height * 16) - 15) {
			moveJump();
		}else {
			y = y - 5;
			charSprite.setY(y);
		}
        //down movement
       
        
        if(Gdx.input.isKeyPressed(Input.Keys.F)){
        	System.out.println("Character Coords X: " + x + " Y: " + y);
        }
        //System.out.println("Player coords: x: " + (x / 16) + " y: " + (0 + planet.planetArray.length - (y / 16)));
        batch.begin();
        charSprite.draw(batch);
        batch.end();
	}
	
	public void moveLeft() {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
			charSprite.translateX(-5);
			x = x - 5;
        }
	}
	public void moveRight() {
	    if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
	        charSprite.translateX(5);
		    x = x + 5;
	     }
	    
	}
	
	public void moveJump() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			charSprite.translateY(15);
			y = y + 15;
        }
	}
	
	public void moveTop() {
		if(y + 5 <= planet.height * 16 && y > 0) {
	        if(collide.isCollidingTop(x, y, height, width)) {
		       
	        }else{
	        	 if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
	 	        	
	 				charSprite.translateY(5);
	 	    		y = y + 5;
	 	        }
				
	        }
		}else if(y < 0) {
        	y = 5;
        	charSprite.setY(y);
        }else if(y > planet.height * 16) {
        	y = (planet.height * 16) - 5;
        	charSprite.setY(y);
        }
	}
	public void moveBottom() {
		 if(y + 5 > 0 && y + 5 < planet.height * 16) {
		        if(collide.isCollidingBottom(x, y, height, width)) {
		 	       
		        }else {
		        	if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
		            	charSprite.translateY(-5);
		            	y = y - 5;
		            }
		        	charSprite.translateY(-1);
		        	y = y - 1;
		        }
	        }else if(y > planet.height * 16) {
	        	y = (planet.height * 16) - 5;
	        	charSprite.setY(y);
	        }
	}
	
}
