package gg.twinhead.SandBox.tile;

import gg.twinhead.SandBox.world.World;
import gg.twinhead.SandBox.world.WorldGenerator;

import java.awt.image.BufferedImage;

public enum TileFeature {
	STONE(World.things.getSprite(41)),
	STUMP(World.things.getSprite(32)),
	LILYPAD(World.things.getSprite(44));

	public BufferedImage sprite;


	TileFeature(BufferedImage sprite){
		this.sprite = sprite;
	}


	BufferedImage getSprite(){
		return this.sprite;
	}
}
