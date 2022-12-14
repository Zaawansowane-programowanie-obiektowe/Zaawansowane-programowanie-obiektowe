package com.space.screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Player implements KeyListener
{

    private BufferedImage pSprite;
    private Rectangle rect;
    private double xPos, yPos;
    private int width, height;


    public Player(double xPos, double yPos, int width, int height)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        rect = new Rectangle((int) xPos, (int) yPos, width, height);

        try{
            URL url = this.getClass().getResource("/com/space/images/Player.png");
            pSprite = ImageIO.read(url);

        }catch(IOException e){};


    }

    public void draw(Graphics2D g)
    {
        g.drawImage(pSprite, (int) xPos, (int) yPos, width, height, null);
    }

    public void update(double delta)
    {

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
