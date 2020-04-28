package com.ryanfleming.astardonia;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Inventory {
	int stone = 0, grass = 0, dirt = 0, coal = 0, mythore = 0;
	Block block;
	SpriteBatch batch;
	Texture invTexture;
	int open = -1;
	
	public Inventory() {
		block = new Block();
		batch = new SpriteBatch();
		invTexture = new Texture("Inventory.png");
	}
	
	public void printInventory(){
		if(Gdx.input.isKeyJustPressed(Input.Keys.I)){
			System.out.println("Stone: " + stone + " Grass: " + grass + " Dirt: " + dirt + " Coal: " + coal + " Mythore: " + mythore);
        }
	}
	
	public void renderInventory() {
		batch.begin();
		if(Gdx.input.isKeyJustPressed(Input.Keys.I)){
			open = open * -1;
		}
		if(open == 1) {
			batch.draw(invTexture, Gdx.graphics.getWidth() / 6, Gdx.graphics.getHeight() / 5);
			location();
		}else{
			
		}
		batch.end();
	}
	
	public void location() {
		
		if(stone > 0) {
			batch.draw(block.stone, 190, 560, 50, 50);
		}
		if(grass > 0) {
			batch.draw(block.grass, 310, 560, 50, 50);
		}
		if(dirt > 0) {
			batch.draw(block.dirt, 440, 560, 50, 50);
		}
		if(coal > 0) {
			batch.draw(block.coal, 590, 560, 50, 50);
		}
		if(mythore > 0) {
			batch.draw(block.mythore, 700, 560, 50, 50);
		}
	}
	
	public void easyAdd(int x) {
		switch(x) {
		case 0:
			
		break;
		case 1:
			grass++;
		break;
		case 2:
			dirt++;
		break;
		case 3:
			stone++;
		break;
		case 4:
			coal++;
		break;
		case 5:
			mythore++;
		break;
		case 6:
			
		break;
		}
	}
	
	public void addStone(int x) {
		stone = stone + x;
	}
	
	public void addGrass(int x) {
		grass = grass + x;
	}
	
	public void addDirt(int x) {
		dirt = dirt + x;
	}
	
	public void addCoal(int x) {
		coal = coal + x;
	}
	
	public void addMythore(int x) {
		mythore = mythore + x;
	}
	
	public int getStone() {
		return stone;
	}
	
	public int getGrass() {
		return grass;
	}
	
	public int getDirt() {
		return dirt;
	}
	
	public int getCoal() {
		return coal;
	}
	
	public int getMythore() {
		return mythore;
	}
}
