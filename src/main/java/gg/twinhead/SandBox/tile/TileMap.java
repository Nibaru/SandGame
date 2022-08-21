package gg.twinhead.SandBox.tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TileMap {


	BufferedImage[] sprites;

	BufferedImage spriteSheet;

	public TileMap(String url, int size){
		spriteSheet = getSpriteSheet(url);
		sprites = sliceSheet(size);
	}

	public BufferedImage getSprite(int index){return sprites[index];}

	public int spriteCount(){
		return sprites.length;
	}


	private BufferedImage[] sliceSheet(int spriteSize) {
		BufferedImage[] img = new BufferedImage[spriteSheet.getWidth() / spriteSize * spriteSheet.getHeight() / spriteSize];

		int count= 0;
		for (int i = 0; i < spriteSheet.getWidth() / spriteSize; i++) {
			for (int j = 0; j < spriteSheet.getHeight() / spriteSize; j++) {
				img[count++] = spriteSheet.getSubimage(i * spriteSize, j * spriteSize, spriteSize, spriteSize);
			}
		}
		return img;
	}

	public BufferedImage getSpriteSheet(String fileName) {
		try {
			return ImageIO.read(getClass().getClassLoader().getResourceAsStream(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}



}
