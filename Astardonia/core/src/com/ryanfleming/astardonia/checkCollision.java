package com.ryanfleming.astardonia;

public class checkCollision {
	
	GeneratePlanet planet;
	int[][] planetArray;
	public checkCollision(GeneratePlanet planet) {
		this.planet = planet;
		this.planetArray = planet.planetArray.clone();
	}
	
	public boolean isCollidingTop(int x, int y, int height, int width) {
		height = height / 16;
		width = width / 16;
		int tempY = planet.height - (y / 16) - height;
		//System.out.println("tempY: " + tempY);
		if(tempY + 1 < planet.height && (x / 16) < planet.width && (x / 16) >= 0) {
			if(planetArray[tempY + 1][x / 16] != 0) {
				//System.out.println(planetArray[tempY][x/ 16]);
				//System.out.println("Colliding Top at: x: " + x / 16 + " y: " + tempY + " height : " + height);
				return true;
					
			}else {
				return false;
			}
		}
		return false;
	}
	
	public boolean isCollidingBottom(int x, int y, int height, int width) {
		height = height / 16;
		width = width / 16;
		int tempY = planet.height - (y / 16);
		//System.out.println("tempY: " + tempY);
		if(tempY < planet.height && tempY >= 0 && (x / 16) < planet.width && (x / 16) >= 0) {
			if(planetArray[tempY - 1][(x / 16)] != 0) {
				//System.out.println(planetArray[tempY][x / 16]);
				//System.out.println("Colliding Bottom at: x: " + x / 16 + " y: " + tempY + " height : " + height);
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public boolean isCollidingRight(int x, int y, int height, int width) {
		/*height = height / 16;
		width = width / 16;
		int tempY = planet.height - (y / 16);
		//System.out.println("tempY: " + tempY);
		if(tempY < planet.height && (x / 16) < planet.width && (x / 16)+ 1 >= 0) {
			if(planetArray[tempY][((x / 16)) + 1] != 0) {
				//System.out.println(planetArray[tempY][x / 16]);
				//System.out.println("Colliding Bottom at: x: " + x / 16 + " y: " + tempY + " height : " + height);
				return true;
			}else {
				return false;
			}
		}*/
		return false;
	}
	
	public boolean isCollidingLeft(int x, int y, int height, int width) {
		/*height = height / 16;
		width = width / 16;
		int tempY = planet.height - (y / 16);
		//System.out.println("tempY: " + tempY);
		if(tempY < planet.height && (x / 16) < planet.width && (x / 16) - 1 >= 0) {
			if(planetArray[tempY][(x / 16) - 1] != 0) {
				//System.out.println(planetArray[tempY][x / 16]);
				//System.out.println("Colliding Bottom at: x: " + x / 16 + " y: " + tempY + " height : " + height);
				return true;
			}else {
				return false;
			}
		}*/
		return false;
	}
}

