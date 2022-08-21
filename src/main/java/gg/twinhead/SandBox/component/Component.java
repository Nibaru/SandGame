package gg.twinhead.SandBox.component;

import gg.twinhead.SandBox.util.Vector;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Component {


	public Vector pos;
	public int width, height;

	public Component(int x, int y, int width, int height){
		pos = new Vector(x, y);
		this.width = width;
		this.height = height;
	}

	public Rectangle getBounds(){
		return new Rectangle((int) pos.x, (int) pos.y, width, height);
	}

	public void update(){};

	public void draw(Graphics2D g){}

}
