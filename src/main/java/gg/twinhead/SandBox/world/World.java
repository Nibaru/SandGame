package gg.twinhead.SandBox.world;

import gg.twinhead.SandBox.tile.Tile;
import gg.twinhead.SandBox.tile.TileMap;
import gg.twinhead.SandBox.tile.TileType;
import gg.twinhead.SandBox.util.Vector;

import java.awt.*;
import java.util.Random;

public class World {

	Tile[][] tiles;



	public final int width;
	public final int height;

	public final int tileSize = 32;

	public static TileMap grass, sand, water, things;

	public TileType lastType;

	public int offsetX, offsetY;

	public World(int width, int height){
		this.width = width;
		this.height = height;

		this.offsetX =0;
		this.offsetY =0;

		grass = new TileMap("Grass.png", 16);
		sand = new TileMap("Tilled Dirt.png", 16);
		water = new TileMap("Water.png", 16);
		things = new TileMap("things.png", 16);
		WorldGenerator worldGenerator = new WorldGenerator(this, width, height);

		tiles = worldGenerator.generateInverse(this, width, height);

		for(int i = 0; i < width - 1; i ++) {
			for(int j = 0; j < height - 1; j ++) {
				tiles[i][j].update();
			}
		}
	}

	public Tile getTile(int x, int y){
		return tiles[x][y];
	}


	private Tile[][] generateWorld(){
		Tile[][] t = new Tile[width][height];

		for(int i = 0; i < width; i ++) {
			for(int j = 0; j < height; j ++) {
				t[i][j] = getGeneratedTile(i, j);
			}
		}

		return t;
	}

	private Tile getGeneratedTile(int x, int y) {
		int v = new Random().nextInt(100);
		TileType type;

		if(v > 80) {
			type = TileType.WATER;
		} else if (lastType == TileType.WATER && v > 60) {
			type = TileType.WATER;
		} else{
			type = TileType.GRASS;
		}

		lastType = type;
		return new Tile(type, this, x, y);
	}


	public void draw(Graphics2D g){
		if (tiles.length == 0) return;

		Tile[][] tilesCopy = tiles;

		int row= 0, col = 0;
		while(col < height -1){
			for (int x = 0; x < width - 1; x++) {
				if(offsetX + x * tileSize > -32 && offsetX + x * tileSize < 1032)
					if(offsetY + col * tileSize > -32 && offsetY + col * tileSize < 732)
						tilesCopy[x][col].draw(g);
			}
			col++;
		}
//		for (int x = 0; x < width - 1; x++) {
//			for (int y = 0; y < height - 1; y++) {
//				tiles[x][y].draw(g);
//			}
//		}
	}

	public void update() {
		if (tiles.length == 0) tiles = generateWorld();


	}
}
