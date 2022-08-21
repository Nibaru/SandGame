package gg.twinhead.SandBox.tile;

import gg.twinhead.SandBox.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Tile {

	public TileType tileType;
	private World world;
	private BufferedImage sprite;

	public TileFeature feature;

	private boolean[] surroundingLikeType;

	public int x, y;

	private boolean sameOnAllSides = false;

	public Tile(TileType tileType, World world, int x, int y) {
		this.tileType = tileType;
		this.x = x;
		this.y = y;
		this.world = world;
		surroundingLikeType = new boolean[]{false, false, false, false,false, false, false, false};

		if(this.tileType == TileType.GRASS){

		}

	}

	public void update(){
		if(sprite == null){
			sprite = getSprite();
		}
	}




	public BufferedImage getSprite(){
		BufferedImage image = null;
		switch (this.tileType){
			case SAND -> {

				getSurrounding(TileType.WATER);

				if (!surroundingLikeType[0] && !surroundingLikeType[1]
						&&!surroundingLikeType[2] && !surroundingLikeType[3]){
					sameOnAllSides = true;

				} else if (surroundingLikeType[0] && surroundingLikeType[1]
						&& !surroundingLikeType[2] && surroundingLikeType[3]){
					image = World.sand.getSprite(3);


				} else if (!surroundingLikeType[0] && surroundingLikeType[1]
						&& surroundingLikeType[2] && surroundingLikeType[3]){
					image = World.sand.getSprite(5);
				} else if (surroundingLikeType[0] && !surroundingLikeType[1]
						&& !surroundingLikeType[2] && surroundingLikeType[3]){
					image = World.sand.getSprite(11);
				} else if (surroundingLikeType[0] && surroundingLikeType[1]
						&& !surroundingLikeType[2] && !surroundingLikeType[3]){
					image = World.sand.getSprite(27);
				} else if (surroundingLikeType[0] && !surroundingLikeType[1]
						&& !surroundingLikeType[2] && !surroundingLikeType[3]){
					image = World.sand.getSprite(19);
				} else if (!surroundingLikeType[0] && !surroundingLikeType[1]
						&& !surroundingLikeType[2] && surroundingLikeType[3]){
					image = World.sand.getSprite(12);
				} else if (surroundingLikeType[0] && !surroundingLikeType[1]
						&& surroundingLikeType[2] && surroundingLikeType[3]){
					image = World.sand.getSprite(14);
				} else if (surroundingLikeType[0] && surroundingLikeType[1]
						&& surroundingLikeType[2] && !surroundingLikeType[3]){
					image = World.sand.getSprite(30);
				} else if (!surroundingLikeType[0] && !surroundingLikeType[1]
						&& surroundingLikeType[2] && surroundingLikeType[3]){
					image = World.sand.getSprite(13);
				} else if (!surroundingLikeType[0] && surroundingLikeType[1]
						&& surroundingLikeType[2] && !surroundingLikeType[3]){
					image = World.sand.getSprite(29);
				} else if (!surroundingLikeType[0] && !surroundingLikeType[1]
						&& surroundingLikeType[2] && !surroundingLikeType[3]){
					image = World.sand.getSprite(21);
				} else if (!surroundingLikeType[0] && surroundingLikeType[1]
						&& !surroundingLikeType[2] && !surroundingLikeType[3]){
					image = World.sand.getSprite(28);
				}


				if(sameOnAllSides){
					int rand = new Random().nextInt(10);
					if(rand == 0){
						image = World.sand.getSprite(0);
					} else if (rand == 1) {
						image = World.sand.getSprite(1);
					} else if (rand <= 2) {
						image = World.sand.getSprite(8);
					} else if (rand <= 3) {
						image = World.sand.getSprite(9);
					} else if (rand <= 4) {
						image = World.sand.getSprite(16);
					} else if (rand <= 5) {
						image = World.sand.getSprite(17);
					}else{
						image = World.sand.getSprite(0);
					}


					if(surroundingLikeType[4] && !surroundingLikeType[5] &&
							!surroundingLikeType[6] && !surroundingLikeType[7]){
						image = World.sand.getSprite(36);
						sameOnAllSides = false;

					} else if(!surroundingLikeType[4] && surroundingLikeType[5] &&
							!surroundingLikeType[6] && !surroundingLikeType[7]){
						image = World.sand.getSprite(37);
						sameOnAllSides = false;

					} else if(surroundingLikeType[4] && !surroundingLikeType[5] &&
							!surroundingLikeType[6] && surroundingLikeType[7]){
						image = World.sand.getSprite(55);
						sameOnAllSides = false;
					} else if(!surroundingLikeType[4] && !surroundingLikeType[5] &&
							!surroundingLikeType[6] && surroundingLikeType[7]){
						image = World.sand.getSprite(44);
						sameOnAllSides = false;
					} else if(!surroundingLikeType[4] && surroundingLikeType[5] &&
							surroundingLikeType[6] && !surroundingLikeType[7]){
						image = World.sand.getSprite(62);
						sameOnAllSides = false;
					}else if(!surroundingLikeType[4] && !surroundingLikeType[5] &&
							surroundingLikeType[6] && !surroundingLikeType[7]){
						image = World.sand.getSprite(45);
						sameOnAllSides = false;
					} else if(!surroundingLikeType[4] && !surroundingLikeType[5] &&
							surroundingLikeType[6] && surroundingLikeType[7]){
						image = World.sand.getSprite(54);
						sameOnAllSides = false;
					} else if(surroundingLikeType[4] && !surroundingLikeType[5] &&
							!surroundingLikeType[6] && !surroundingLikeType[7]){
						image = World.sand.getSprite(54);
						sameOnAllSides = false;
					}

				}
			}






			case GRASS -> {


				getSurrounding(TileType.GRASS);

				if (surroundingLikeType[0] &&surroundingLikeType[1]
						&&surroundingLikeType[2] &&surroundingLikeType[3]){
					image = world.grass.getSprite(20);
					sameOnAllSides = true;
				} else if (!surroundingLikeType[0] && !surroundingLikeType[1]
						&& surroundingLikeType[2] && !surroundingLikeType[3]) {
					image = world.grass.getSprite(2);
				}else if (surroundingLikeType[0] && !surroundingLikeType[1]
						&& surroundingLikeType[2] && !surroundingLikeType[3]) {
					image = world.grass.getSprite(3);
				}else if (surroundingLikeType[0] && !surroundingLikeType[1]
						&& !surroundingLikeType[2] && !surroundingLikeType[3]) {
					image = world.grass.getSprite(5);
				} else if (!surroundingLikeType[0] && surroundingLikeType[1]
						&& !surroundingLikeType[2] && !surroundingLikeType[3]) {
					image = world.grass.getSprite(6);
				} else if (!surroundingLikeType[0] && !surroundingLikeType[1]
						&& !surroundingLikeType[2] && surroundingLikeType[3]) {
					image = world.grass.getSprite(30);
				} else if (surroundingLikeType[0] && !surroundingLikeType[1]
						&& surroundingLikeType[2] && surroundingLikeType[3]) {
					image = world.grass.getSprite(28);
				} else if (surroundingLikeType[0] && !surroundingLikeType[1]
						&& !surroundingLikeType[2] && surroundingLikeType[3]) {
					image = world.grass.getSprite(29);
				} else if (!surroundingLikeType[0] && !surroundingLikeType[1]
						&& surroundingLikeType[2] && surroundingLikeType[3]) {
					image = world.grass.getSprite(27);
				} else if (surroundingLikeType[0] && surroundingLikeType[1]
						&& surroundingLikeType[2] && !surroundingLikeType[3]) {
					image = world.grass.getSprite(12);
				} else if (!surroundingLikeType[0] && surroundingLikeType[1]
						&& surroundingLikeType[2] && !surroundingLikeType[3]) {
					image = world.grass.getSprite(11);
				} else if (surroundingLikeType[0] && surroundingLikeType[1]
						&& !surroundingLikeType[2] && surroundingLikeType[3]) {
					image = world.grass.getSprite(21);
				}else if (!surroundingLikeType[0] && surroundingLikeType[1]
						&& surroundingLikeType[2] && surroundingLikeType[3]) {
					image = world.grass.getSprite(19);
				}else if (surroundingLikeType[0] && surroundingLikeType[1]
						&& !surroundingLikeType[2] && !surroundingLikeType[3]) {
					image = world.grass.getSprite(13);
				}else if (!surroundingLikeType[0] && surroundingLikeType[1]
						&& !surroundingLikeType[2] && surroundingLikeType[3]) {
					image = world.grass.getSprite(14);
				}


				if(sameOnAllSides){
					int rand = new Random().nextInt(10);
					if(rand <= 0){
						image = world.grass.getSprite(0);
					} else if (rand <= 1) {
						image = world.grass.getSprite(1);
					} else if (rand <= 2) {
						image = world.grass.getSprite(8);
					} else if (rand <= 3) {
						image = world.grass.getSprite(9);
					} else if (rand <= 4) {
						image = world.grass.getSprite(16);
					} else if (rand <= 5) {
						image = world.grass.getSprite(17);
					}
				}


			}
			case WATER -> {
				image = world.water.getSprite(new Random().nextInt(4));
			}
			case DIRT -> image = null;
		};
		return image;
	}


	public void draw(Graphics2D g){
		if(!sameOnAllSides && this.tileType == TileType.GRASS){
			if (surroundsContains(TileType.WATER)){
				g.drawImage(World.water.getSprite(1),  x * world.tileSize + (int) world.offsetX, y * world.tileSize + (int) world.offsetY, world.tileSize, world.tileSize, null);

			} else if (surroundsContains(TileType.SAND)){
				g.drawImage(World.sand.getSprite(0), x * world.tileSize + (int) world.offsetX, y * world.tileSize + (int) world.offsetY, world.tileSize, world.tileSize, null);
			}
		}

		if(!sameOnAllSides && this.tileType == TileType.SAND) {
				g.drawImage(World.water.getSprite(1), x * world.tileSize + (int) world.offsetX, y * world.tileSize + (int) world.offsetY, world.tileSize, world.tileSize, null);
		}

		g.drawImage(sprite, x * world.tileSize + (int) world.offsetX, y * world.tileSize + (int) world.offsetY, world.tileSize, world.tileSize, null);

		if(feature != null){
			g.drawImage(feature.getSprite(), x * world.tileSize + (int) world.offsetX, y * world.tileSize + (int) world.offsetY, world.tileSize, world.tileSize, null);
		}
	}


	public void getSurrounding(TileType type){
		if(y < world.height-1)
			if(world.getTile(x, y + 1).tileType == type)
				surroundingLikeType[2] = true;

		if(y > 0)
			if(world.getTile(x, y - 1).tileType == type)
				surroundingLikeType[0] = true;

		if(x < world.width)
			if(world.getTile(x + 1, y ).tileType == type)
				surroundingLikeType[1] = true;

		if(x > 0)
			if(world.getTile(x - 1, y ).tileType == type)
				surroundingLikeType[3] = true;

		if(y < world.height-1 && x < world.width)
			if(world.getTile(x + 1, y + 1).tileType == type)
				surroundingLikeType[4] = true;

		if(y > 0 && x < world.width)
			if(world.getTile(x + 1, y - 1).tileType == type)
				surroundingLikeType[5] = true;

		if(y < world.height-1 && x > 0)
			if(world.getTile(x - 1, y + 1).tileType == type)
				surroundingLikeType[7] = true;

		if(y > 0 && x > 0)
			if(world.getTile(x - 1, y - 1).tileType == type)
				surroundingLikeType[6] = true;
	}


	public boolean surroundsContains(TileType type){
		for (Tile t: this.getSurroundingTiles()) {
			if (t.tileType == type){
				return true;
			}
		}
		return false;
	}

	public List<Tile> getSurroundingTiles() {
		List<Tile> surrounds = new ArrayList<>();

		if (y < world.height)
			surrounds.add(world.getTile(x, y + 1));

		if (y > 0)
				surrounds.add(world.getTile(x, y - 1));

		if (x < world.width)
				surrounds.add(world.getTile(x + 1, y));

		if (x > 0)
			surrounds.add(world.getTile(x - 1, y));

		if(y < world.height-1 && x < world.width)
			surrounds.add(world.getTile(x + 1, y + 1));

		if(y > 0 && x < world.width)
			surrounds.add(world.getTile(x + 1, y - 1));

		if(y > 0 && x < world.width)
			surrounds.add(world.getTile(x + 1, y -1));

		if(y < world.height-1 && x > 0)
			surrounds.add(world.getTile(x - 1, y + 1));

		return surrounds;
	}
}
