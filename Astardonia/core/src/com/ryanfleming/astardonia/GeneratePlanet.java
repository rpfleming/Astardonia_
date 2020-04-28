package com.ryanfleming.astardonia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratePlanet {
	//info variables
	NameGenerator gen = new NameGenerator();
	String name = gen.planet();
	int[][] planetArray = planetArray();
	int height, width;
	List<int[][]> planetChunks = new ArrayList<int[][]>();
	int chunkHeight = 10, chunkWidth = 10;
	int numChunks = (height * width) / (chunkHeight * chunkWidth);
	Block block = new Block();
	int whatChunk;
	int[][] tempChunk;
	int planetCenterX = ((width)) / 2, planetCenterY = (height * 16) - 10 * 16; //used to determine the spawn location of the player
	int passedBlock = 0;
	Inventory inventory = new Inventory();
	
	public GeneratePlanet() {
		chunks();
		planetInfo();
	}
	
	public void renderChunk(int z, int x, int y) { //z chunk number
		int[][] chunkTemp = planetChunks.get(z);
		for(int i = 0; i < chunkHeight; i++) {
			for(int j = 0; j < chunkWidth; j++) {
				block.render(chunkTemp[i][j], x + (j * 16), (y - (i * 16)), z);
				click(z, j, i);
				passedBlock = block.type;
			}
		}
	}
	
	public void planetInfo() {
		System.out.println("Planet: " + name);
		System.out.println("\nPlanet Array: ");
		printPlanetFull();
		System.out.println("\n Chunks: ");
		printPlanet();
	}
	
	public void printPlanet() {
		for(int i = 0; i < numChunks; i++) {
			int[][] chunkTemp = planetChunks.get(i);
			System.out.print("\nChunk: (" + i + ")\n");
			for(int j = 0; j < chunkHeight; j++) {
				for(int k = 0; k < chunkWidth; k++) {
					System.out.print(chunkTemp[j][k]);
					
				}
				System.out.println();
			}
		}
		
	}
	
	public void printPlanetFull() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j< width; j++) {
				System.out.print(planetArray[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int firstDigit(int n) {
		  while (n < -9 || 9 < n) n /= 10;
		  return Math.abs(n);
	}
	
	public void click(int z, int xC, int yC) {
		if (block.isClicked()) {
			tempChunk = planetChunks.get(z);
			System.out.println("X: " + xC + " Y: " + yC);
			tempChunk[yC][xC] = 0;
			planetChunks.set(z, tempChunk);
			passedBlock = block.type;
			inventory.easyAdd(block.type);
			pass();
		}
	}
	
	public int pass() {
		return passedBlock;
	}
	
	public void chunks() {		
		for(int i = 0; i < numChunks; i++) {
			int[][] chunkTemp = new int[chunkHeight][chunkWidth];
			
			int startHeight = (chunkHeight * (i / chunkHeight)) % height;
	        int startWidth = (chunkWidth * (i)) % height;
	        if (startHeight + chunkHeight > height) { //
	            startHeight = 0;
	        }
	        
			for(int j = 0; j < chunkHeight; j++) {	
				for (int k = 0; k < chunkWidth; k++) {
		           chunkTemp[j][k] = planetArray[startHeight + j][k + startWidth];
		        }
			}
			planetChunks.add(chunkTemp);
		}
	}
	
	public int[][] planetArray() {
		Random rand = new Random();
		height = 50;
		width = 100;
		planetArray = new int[height][width];
		boolean grassVal[] = new boolean[width];
		int dirtCount[] = new int[width];
		for(int i = 0; i < height; i++) { //0 is air, 1 is grass, 2 is dirt, 3 is stone
			for(int j = 0; j < width; j++) {
				
				if(i <= (height / 5)) {
					//nothing
				}else if(i > (height / 5) && grassVal[j] == false){
					int grassChance = rand.nextInt(10);
					
					if(grassChance <= 6) {
						planetArray[i][j] = 1;
						grassVal[j] = true;
					}else if(i >= height / 4) {
						
					}
				}else if((planetArray[i - 1][j] == 1 || grassVal[j] == true) && dirtCount[j] < 3) {
					planetArray[i][j] = 2;
					dirtCount[j]++;
				}else if(i > (height / 5)) {
					int ores = rand.nextInt(50);
					if(ores <= 45) {
						planetArray[i][j] = 3;
					}else if(ores <= 48) {
						planetArray[i][j] = 4;
					}else if(ores < 50) {
						planetArray[i][j] = 5;
					}else {
						planetArray[i][j] = 6;
					}
					
				}
			}
			
		}
		return planetArray;
	}
}
