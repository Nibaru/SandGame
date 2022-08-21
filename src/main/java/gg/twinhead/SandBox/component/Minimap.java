package gg.twinhead.SandBox.component;

import gg.twinhead.SandBox.util.MouseHandler;
import gg.twinhead.SandBox.world.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Minimap extends ClickableUiComponent{
	public static final int pixelSize = 3;

	private final World world;

	public boolean drawn;

	private final BufferedImage frame;

	public Minimap(int x, int y, MouseHandler mouseHandler, World world) {
		super(x, y, world.width * pixelSize, world.height * pixelSize, mouseHandler);
		this.world = world;
		try {
			frame = ImageIO.read(getClass().getClassLoader().getResourceAsStream("minimap_frame.png"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}



	public void onClick(){


		world.offsetX = (int) -((mouseHandler.mousePos.x) / pixelSize * world.tileSize - 1000 /2.0);
		world.offsetY =  (int)(-((mouseHandler.mousePos.y - pos.y ) / pixelSize * world.tileSize - 700 /2.0));

		System.out.println("X: " + world.offsetX + ": Y" + world.offsetY);
	}


	public void onDrag(){

	}




	@Override
	public void draw(Graphics2D g){
		//if (drawn) return;

		for (int x = 0; x < world.width - 1; x++) {
			for (int y = 0; y < world.height -1; y++) {
				g.setColor(world.getTile(x, y).tileType.color);
				g.fillRect((int) (pos.x + x * pixelSize), (int) (pos.y + y * pixelSize), pixelSize, pixelSize);
			}
		}
		g.drawImage(frame,(int) pos.x, (int) pos.y, width, height * 2, null);
		drawn = true;
	}
}
