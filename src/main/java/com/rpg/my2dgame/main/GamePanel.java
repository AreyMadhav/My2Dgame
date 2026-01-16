package com.rpg.my2dgame.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import com.rpg.my2dgame.entities.Player;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    // Screen Settings
    private final int ORIGINAL_TILE_SIZE = 16;
    private final int SCALE = 3;

    private final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    private final int MAX_SCREEN_COL = 16;
    private final int MAX_SCREEN_ROW = 12;
    private final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    private final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;

    private Thread gameThread;
    private final int FPS = 60;

    private Player player;

    // Input state
    private boolean up, down, left, right;

    public GamePanel() {
        initializePanel();
        initGame();
    }

    private void initializePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(this);
    }

    private void initGame() {
        player = new Player(SCREEN_WIDTH / 2 - 16, SCREEN_HEIGHT / 2 - 16);
        startGameThread();
    }

    private void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            tick();
            repaint();

            try {
                double remaining = nextDrawTime - System.nanoTime();
                if (remaining > 0) {
                    Thread.sleep((long) (remaining / 1000000));
                }
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void tick() {
        player.move(up, down, left, right);
        player.tick();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) up = true;
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) down = true;
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) left = true;
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) right = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) up = false;
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) down = false;
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) left = false;
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) right = false;
    }
}
