package gg.twinhead.SandBox.tile;

import java.awt.*;

public enum TileType {
	SAND(new Color(230, 205, 165, 255)),
	GRASS(new Color(192, 212, 112, 255)),
	WATER(new Color(155, 212, 195, 255)),
	DIRT(new Color(86, 40, 24, 255)),
	BORDER(Color.BLACK)
	;

	public final Color color;

	TileType(Color color){
		this.color = color;
	}

}
