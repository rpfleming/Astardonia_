package com.ryanfleming.astardonia;

public class RenderPlanet {	

	public void render(GeneratePlanet planet, int x, int y) {
		
		for(int i = 0; i < planet.numChunks; i++) {
			int row = i / (planet.width / planet.chunkWidth);
			int col = i % (planet.width / planet.chunkWidth);
			if(x <= - planet.numChunks * 160 / 2) {
				planet.renderChunk(i, col * 160 - 3 - 300, (planet.height * 16) - (row * 160) - 3);
			}else {
				planet.renderChunk(i, col * 160 - 3, (planet.height * 16) - (row * 160) - 3);

			}
		}
	}
}
