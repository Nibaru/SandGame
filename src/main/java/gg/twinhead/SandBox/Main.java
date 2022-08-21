package gg.twinhead.SandBox;

import gg.twinhead.SandBox.game.GameLoop;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static JFrame window;
    public static final  String name = "SandBox Game!";


    public static void main(String[] args) {
        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(1000, 700));



        GameLoop gameLoop = new GameLoop();

        window.add(gameLoop);
        window.pack();
        window.setVisible(true);
        gameLoop.startGameThread();

    }

}