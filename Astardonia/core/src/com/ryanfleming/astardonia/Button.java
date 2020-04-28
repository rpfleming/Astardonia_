package com.ryanfleming.astardonia;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button {
	
	int x, y, width, height;
	Texture textureUp, textureDown, textureHover;
	SpriteBatch batch = new SpriteBatch();
	
	public Button(Texture textureUp, Texture textureDown, Texture textureHover, int x, int y, int width, int height) {
	 	this.x = x;
	 	this.y = y;
	 	this.width = width;
	 	this.height = height;
	 	this.textureUp = textureUp;
	 	this.textureDown = textureDown;
	 	this.textureHover = textureHover;
	}
	
	public void update() {
		batch.begin();
		if(isClicked()) {
			batch.draw(textureDown, x, y, width, height);
		}else if(isHovering()) {
			batch.draw(textureHover, x, y, width, height);
		}else {
			batch.draw(textureUp, x, y, width, height);
		}
		batch.end();
	}
	
	public boolean isClicked() {
		if(Gdx.input.getX() > x && Gdx.input.getX() < x + width && (Gdx.graphics.getHeight() - Gdx.input.getY() < y + height && Gdx.graphics.getHeight() - Gdx.input.getY() > y)) {
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
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
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
}