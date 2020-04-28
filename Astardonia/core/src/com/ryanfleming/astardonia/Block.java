package com.ryanfleming.astardonia;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Block{
	SpriteBatch batch;
	Texture stone, air, grass, dirt, mythore, coal, bedrock; //all blocks
	Texture outline; //ui
	int y = 0, x = 0, width = 16, height = 16, chunk = 0;
	int type = 0;
	
	public Block() {//initialize all textures once
		
		//Block Textures
		batch = new SpriteBatch();
		stone = new Texture("Stone.png");
		air = new Texture("Air.png");
		grass = new Texture("Grass2.png");
		dirt = new Texture("Dirt.png");
		mythore = new Texture("Mythore.png");
		coal = new Texture("Coal.png");
		bedrock = new Texture("BedRock.png");
		//End Block Textures
		
		outline = new Texture("outline.png");
	}
	
	public void render(int type, int x, int y, int chunk) { //use this method to render the block
		this.x = x;
		this.y = y;
		this.chunk = chunk;
		this.type = type;
		
		batch.begin();
		pickBlock();
		input();
		batch.end();
	}
	
	public void input() {//take user input and perform actions
		if(isHovering()) {
			batch.draw(outline, x, y);
		}
		if(isClicked()){
			System.out.println("Coords: x: " + (x / width) + " y: " + (y / height));
			System.out.println("Block Type: " + nameReturn());
			System.out.println("Chunk: " + chunk);
		}
	}
	
	public void pickBlock() {
		switch(type) {
		case 0:
			batch.draw(air, x, y);
		break;
		case 1:
			batch.draw(grass, x, y);
		break;
		case 2:
			batch.draw(dirt, x, y);
		break;
		case 3:
			batch.draw(stone, x, y);
		break;
		case 4:
			batch.draw(coal, x, y);
		break;
		case 5:
			batch.draw(mythore, x, y);
		break;
		case 6:
			batch.draw(bedrock, x, y);
		break;
		}
	}
	
	public String nameReturn() {
		switch(type) {
		case 0:
			return "Air";
		case 1:
			return "Grass";
		case 2:
			return "Dirt";
		case 3:
			return "Stone";
		case 4:
			return "Coal";
		case 5:
			return "Mythore";
		case 6:
			return "Bedrock";
		default:
			return "Air";
		}
	}
	
	public int whatChunk() {//returns the chunk the block belongs to
		return chunk;
	}
	
	//Input Methods
	public boolean isClicked() {
		if(Gdx.input.getX() > x && Gdx.input.getX() < x + width && (Gdx.graphics.getHeight() - Gdx.input.getY() < y + height && Gdx.graphics.getHeight() - Gdx.input.getY() > y)) {
			if(Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean isHovering() {
		if(Gdx.input.getX() > x && Gdx.input.getX() < x + width && (Gdx.graphics.getHeight() - Gdx.input.getY() < y + height && Gdx.graphics.getHeight() - Gdx.input.getY() > y)) {
			if(Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	//End Input Methods
	
	public void dispose() {
		outline.dispose();
		stone.dispose();
	}
}
