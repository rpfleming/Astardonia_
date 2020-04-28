package com.ryanfleming.astardonia;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu{
	SpriteBatch batch;
	
	//buttons
	Texture stars, start, startHover, startClicked, options, optionsHover, optionsClicked, exit, exitHover, exitClicked, audio, audioHover, audioClicked, back, backHover, backClicked, resolution, resolutionHover, resolutionClicked;
	int mainMenu = 0; //0 for main menu, 1 for start, 2 for options
	int startWidth = 400, startHeight = 100;
	int startX = (Gdx.graphics.getWidth() / 2) - (startWidth / 2), startY = Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 3;
	int optionsWidth = 300, optionsHeight = 75;
	int optionsX = (Gdx.graphics.getWidth() / 2) - (optionsWidth / 2), optionsY = Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2;
	int exitWidth = 200, exitHeight = 50;
	int exitX = (Gdx.graphics.getWidth() / 2) - (exitWidth / 2), exitY = Gdx.graphics.getHeight() - (2 * (Gdx.graphics.getHeight() / 3));
	//end buttons
	
	//Option Buttons
	int audioWidth = 400, audioHeight = 100;
	int audioX = (Gdx.graphics.getWidth() / 2) - (startWidth / 2), audioY = Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 3;
	//End Option Buttons
	Button btnStart, btnOptions, btnExit, btnAudio, btnBack, btnResolution;
	
	GeneratePlanet planet = new GeneratePlanet();
	RenderPlanet render = new RenderPlanet();
	Character player;
	Inventory inventory;
	
	public MainMenu() {
		batch = new SpriteBatch();
		stars = new Texture("Stars.png");
		start = new Texture("Buttons/Start.png");
		startHover = new Texture("Buttons/StartHover.png");
		startClicked = new Texture("Buttons/StartClicked.png");
		options = new Texture("Buttons/Options.png");
		optionsHover = new Texture("Buttons/OptionsHover.png");
		optionsClicked = new Texture("Buttons/OptionsClicked.png");
		exit = new Texture("Buttons/Exit.png");
		exitHover = new Texture("Buttons/ExitHover.png");
		exitClicked = new Texture("Buttons/ExitClicked.png");
		audio = new Texture("Buttons/Audio.png");
		audioHover = new Texture("Buttons/AudioHover.png");
		audioClicked = new Texture("Buttons/AudioClicked.png");
		back = new Texture("Buttons/Back.png");
		backHover = new Texture("Buttons/BackHover.png");
		backClicked = new Texture("Buttons/BackClicked.png");
		resolution = new Texture("Buttons/Resolution.png");
		resolutionHover = new Texture("Buttons/ResolutionHover.png");
		resolutionClicked = new Texture("Buttons/ResolutionClicked.png");
		
		btnStart = new Button(start, startClicked, startHover, startX, startY, startWidth, startHeight);
		btnOptions = new Button(options, optionsClicked, optionsHover, optionsX, optionsY, optionsWidth, optionsHeight);
		btnExit = new Button(exit, exitClicked, exitHover, exitX, exitY, exitWidth, exitHeight);
		btnAudio = new Button(audio, audioClicked, audioHover, audioX, audioY, audioWidth, audioHeight);
		btnBack = new Button(back, backClicked, backHover, exitX, exitY, exitWidth, exitHeight);
		btnResolution = new Button(resolution, resolutionClicked, resolutionHover, optionsX, optionsY, optionsWidth, optionsHeight);
		
		player = new Character(planet, planet.planetCenterX, planet.planetCenterY);
		inventory = new Inventory();
	}
	
	public void runMenu() {
		
		if(mainMenu == 0) {// display main menu
			setWallpaper();
			buttons();
		}else if(mainMenu == 1) { // display world creation screen and character maker
			render.render(planet, player.x - planet.planetCenterX, player.y - planet.planetCenterY);
			
			inventory = planet.inventory;
			inventory.printInventory();
			inventory.renderInventory();
			
			player.handleMovement(planet);
			if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
				mainMenu = 0;
	        }
		}else if(mainMenu == 2) { // display options menu
			setWallpaper();
			optionsMenu();
		}else if(mainMenu == 3) {
			setWallpaper();
			audioMenu();
		}else if(mainMenu == 4) {
			setWallpaper();
			resolutionMenu();
		}
		
	}
	
	public void resolutionMenu() {
		backButton(2);
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			mainMenu = 2;
        }
	}
	
	public void audioMenu() {
		backButton(2);
	}
	
	public void optionsMenu() {
		audioButton();
		resolutionButton();
		backButton(0);
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			mainMenu = 0;
        }
	}
	
	public void buttons() {
		startButton();
		optionsButton();
		exitButton();
	}
	
	public void resolutionButton() {
		btnResolution.update();
		if(btnResolution.isClicked()) {
			mainMenu = 4;
		}
	}
	
	public void backButton(int x) {
		btnBack.update();
		if(btnBack.isClicked()) {
			mainMenu = x;
		}
	}
	
	public void audioButton() {
		btnAudio.update();
		if(btnAudio.isClicked()) {
			mainMenu = 3;
		}
	}
	
	public void startButton() {
		btnStart.update();
		if(btnStart.isClicked()) {
			mainMenu = 1;
		}
	}
	
	public void optionsButton() {
		btnOptions.update();
		if(btnOptions.isClicked()) {
			mainMenu = 2;
		}
	}
	
	public void exitButton() {
		btnExit.update();
		if(btnExit.isClicked()) {
			dispose();
			System.exit(0);
		}
	}
	
	public void setWallpaper() {
		stars.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
		batch.begin();
		batch.draw(stars, 0, 0, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
	}

	public void dispose() {
		stars.dispose();
		start.dispose();
		startHover.dispose();
		startClicked.dispose();
		options.dispose();
		optionsHover.dispose();
		optionsClicked.dispose();
		exit.dispose();
		exitHover.dispose();
		exitClicked.dispose();
	}
}
