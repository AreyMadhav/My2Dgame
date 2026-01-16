package com.rpg.my2dgame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Player {
    private int x, y;
    private int width = 32;
    private int height = 32;
    private int speed = 4;
    private Image sprite;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        // Try loading player sprite from resources; if missing, fallback to a rectangle
        try {
            java.net.URL url = getClass().getResource("/com/rpg/my2dgame/resources/player.png");
            if (url != null) {
                ImageIcon icon = new ImageIcon(url);
                sprite = icon.getImage();
            } else {
                sprite = null;
            }
        } catch (Exception e) {
            sprite = null;
        }
    }

    public void tick() {
        // reserved for future state updates
    }

    public void move(boolean up, boolean down, boolean left, boolean right) {
        if (up) y -= speed;
        if (down) y += speed;
        if (left) x -= speed;
        if (right) x += speed;
    }

    public void render(Graphics g) {
        if (sprite != null && sprite.getWidth(null) > 0) {
            g.drawImage(sprite, x, y, width, height, null);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width, height);
        }
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
