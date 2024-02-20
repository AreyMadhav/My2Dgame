package com.rpg.my2dgame.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Player {
    private int x, y;
    private int width = 32;
    private int height = 32;
    private Image sprite;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        // Load player sprite
        ImageIcon icon = new ImageIcon("path_to_your_sprite_image.png");
        sprite = icon.getImage();
    }

    public void tick() {
        // Update player state
    }

    public void render(Graphics g) {
        g.drawImage(sprite, x, y, width, height, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
