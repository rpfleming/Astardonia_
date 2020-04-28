package com.ryanfleming.astardonia;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Astardonia extends ApplicationAdapter {
	SpriteBatch batch;
	MainMenu main;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		main = new MainMenu();
	}

	@Override
	public void render () {
		main.runMenu();
	}
	
	@Override
	public void dispose () {
		
	}
}
