package com.rpg.my2dgame.main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    // SCREEN SETTINGS
    
    final int originalTileSize = 16; // 16x16
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12; //4:3
    final int screenWidth = tileSize * maxScreenCol; //768p
    final int screenHeight = tileSize * maxScreenRow; //576p
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
