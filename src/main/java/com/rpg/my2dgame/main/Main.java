package com.rpg.my2dgame.main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGame);
    }

    private static void createAndShowGame() {
        JFrame window = new JFrame("2D RPG");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

