package gg.twinhead.SandBox.world;

import gg.twinhead.SandBox.tile.Tile;
import gg.twinhead.SandBox.tile.TileFeature;
import gg.twinhead.SandBox.tile.TileType;

import java.util.*;

import static gg.twinhead.SandBox.tile.TileType.*;

public class WorldGenerator {



	Tile[][] tiles;
	World world;

	int w = 128,h = 128;

	int lakeMin = 20;
	int lakeMax = 200;

	Set<Tile> lakeTiles;
	Tile lastTile;

	public WorldGenerator(World world, int width, int height){
		this.world = world;
		this.w = width;
		this.h = height;
		tiles = new Tile[w][h];
	}

	public Tile[][] generate(World world, int w, int h){

		for(int i = 0; i < w; i ++) {
			for(int j = 0; j < h; j ++) {
				this.tiles[i][j] = new Tile(TileType.GRASS, world, i , j);
			}
		}

		Random rand = new Random();

		for (int i = 0; i < w; i++) {
			addLake(i, h - 1, WATER);
			addLake(i, 0, WATER);
		}

		for (int i = 0; i < h; i++) {
			addLake(0, i, WATER);
			addLake(w - 1, i, WATER);
		}


//		for (int i = 0; i < rand.nextInt(10, 15); i++) {
//			addLake(rand.nextInt(w), rand.nextInt(h));
//		}

		return this.tiles;
	}

	public Tile[][] generateInverse(World world, int w, int h){

		for(int i = 0; i < w; i ++) {
			for(int j = 0; j < h; j ++) {
				this.tiles[i][j] = new Tile(WATER, world, i , j);
			}
		}

		Random rand = new Random();

		for (int i = 0; i < w; i += 3) {
			if(i > 10 && i < w - 10)
				addLake(i, h /2 - 5, GRASS);
		}

		addStone();


//		for (int i = 0; i < rand.nextInt(10, 15); i++) {
//			addLake(rand.nextInt(w), rand.nextInt(h));
//		}

		return this.tiles;
	}


	public void addLake(int x, int y, TileType type){
		lakeTiles = new HashSet<>();
		Random random = new Random();
		int lakeSize = random.nextInt(lakeMin, lakeMax);

		lastTile = tiles[x][y];
		while (lakeTiles.size() <= lakeSize ){
			spreadWater(lastTile.x, lastTile.y, random);
		}

		for (Tile lt: lakeTiles) {
			if(lt != null && lt.tileType != type){
				tiles[lt.x][lt.y].tileType = type;
				//tiles[lt.x][lt.y].update();
			}
		}

		List<Tile> lakeEdge = new ArrayList<>();
		for (Tile lt: lakeTiles) {
			if(surroundsContains(lt.x, lt.y, GRASS) && surroundsContains(lt.x, lt.y, WATER)){
				lakeEdge.add(lt);
			}
			System.out.println(surroundsContains(lt.x, lt.y, WATER));

		}


		for (Tile t: lakeEdge) {
			if(random.nextInt(10) > 1)
				tiles[t.x][t.y].tileType = SAND;

			if(random.nextInt(10) > 0)
				for (Tile ts: getSurroundingTiles(t.x , t.y)) {
					tiles[ts.x][ts.y].tileType = SAND;
				}
		}
	}

	public void addStone(){
		for(int i = 0; i < w; i ++) {
			for (int j = 0; j < h; j++) {
				if (tiles[i][j].tileType == GRASS){
					if (new Random().nextInt(10) == 0){
						tiles[i][j].feature = TileFeature.STONE;
					}
				}
			}
		}
	}


	public void spreadWater(int x, int y, Random random){

		for (Tile t: getSurroundingTiles(x, y)) {
			if(random.nextInt(4) > 1 && random.nextInt(4) < 2){
				lakeTiles.addAll(getSurroundingTiles(x, y));
				//spreadWater(t.x, t.y, random, lakeSize);
				lastTile = t;
				return;
			}
		}
	}



	public Tile getAbove(Tile tile) {
		if (tile.y < h - 1)
			return tiles[tile.x][tile.y + 1];
		else return null;
	}

	public Tile getBelow(Tile tile) {
		if (tile.y > 0)
			return tiles[tile.x][tile.y - 1];
		else return null;
	}

	public Tile getLeft(Tile tile) {
		if (tile.x > 0)
			return tiles[tile.x - 1][tile.y];
		else return null;
	}

	public Tile getRight(Tile tile) {
		if (tile.x < w - 1)
			return tiles[tile.x + 1][tile.y];
		else return null;
	}

	public boolean surroundsContains(int x, int y, TileType type){
		for (Tile t: getSurroundingTiles(x, y)) {
			if (t.tileType == type){
				return true;
			}
		}
		return false;
	}


	public List<Tile> getSurroundingTiles(int x, int y) {
		List<Tile> surrounds = new ArrayList<>();
		if (y < h -1)
			surrounds.add(tiles[x] [y + 1]);

		if (y > 0)
			surrounds.add(tiles[x] [y - 1]);

		if (x < w - 1)
			surrounds.add(tiles[x + 1][y]);

		if (x > 0)
			surrounds.add(tiles[x - 1][y]);
		return surrounds;
	}









}
