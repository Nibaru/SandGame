package gg.twinhead.SandBox.util;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseMotionListener, MouseListener {

	public Point mousePos;

	public boolean mouse1 = false;

	public Long timeSinceLastDrag = 0L ;


	@Override
	public void mouseDragged(MouseEvent e) {
		//System.out.println(e.getX() + " : " + e.getY() + " " + e.getButton());
		mousePos = new Point(e.getX(), e.getY());


	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePos = e.getPoint();

		switch (e.getButton()){
			case 1 -> mouse1 = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()){
			case 1 -> mouse1 = false;
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
