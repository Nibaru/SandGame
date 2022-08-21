package gg.twinhead.SandBox.game;

import gg.twinhead.SandBox.Main;
import gg.twinhead.SandBox.component.ClickableUiComponent;
import gg.twinhead.SandBox.component.Minimap;
import gg.twinhead.SandBox.util.MouseHandler;
import gg.twinhead.SandBox.world.World;

import javax.swing.*;
import java.awt.*;

public class GameLoop extends JPanel implements Runnable {

	Thread gameThread;
	final int FPS = 60;
	int tickCount = 0;

	World world;
	Minimap c;

	public GameLoop(){
		this.setPreferredSize(new Dimension(1000, 700));
		this.setBackground(Color.DARK_GRAY);
		this.setFocusable(true);

		//TODO Keyhandler

		MouseHandler mouseHandler = new MouseHandler();

		this.addMouseMotionListener(mouseHandler);
		this.addMouseListener(mouseHandler);

		this.world = new World(128, 64);
		this.c = new Minimap(0,528, mouseHandler, world);

	}

	public void update(){
		world.update();
		c.update();
	}


	public void draw(Graphics2D g){
		world.draw(g);
		c.draw(g);
	}











	public void startGameThread(){
		this.gameThread = new Thread(this);
		this.gameThread.start();
	}
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / FPS;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;


		while (gameThread.isAlive()) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {
				ticks++;
				tick();
				update();
				delta -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			if (shouldRender) {
				frames++;
				repaint();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				Main.window.setTitle(Main.name + " " + ticks + " ticks, " + frames + " frames");
				frames = 0;
				ticks = 0;
			}
		}
	}
	public void tick(){
		tickCount++;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//Flip the screen
//		AffineTransform tform = AffineTransform.getTranslateInstance( 0, HEIGHT);
//		tform.scale( 1, -1);
//		g2.setTransform( tform);
		draw(g2);

		g2.dispose();
	}
}
