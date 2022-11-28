package com.space.sprite;

import com.space.timer.Timer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpriteAnimation
{

    private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
    private byte currentSprite;

    private boolean loop = false;
    private boolean play = false;
    private boolean destroyAfterAnim = false;
    private Timer timer;
    private int animationSpeed;
    private double xPos, yPos;

    public SpriteAnimation(double xPos, double yPos, int animationSpeed)
    {
        this.animationSpeed = animationSpeed;
        this.xPos = xPos;
        this.yPos = yPos;

        timer = new Timer();
    }

    public void draw(Graphics2D g)
    {
        g.drawImage(sprites.get(currentSprite), (int) getxPos(), (int) getyPos(), null);
    }

    public void update(double delta)
    {
        if(isSpriteAnimDestroyed())
            return;

        if(loop && !play)
        {
            loopAnimation();
            if(play && !loop)
            {
                playAnimation();
            }
        }
    }

    public void stopAnimation()
    {
        loop = false;
        play = false;
    }

    public void resetSprite()
    {
        loop = false;
        play = false;
        currentSprite = 0;
    }

    private void loopAnimation()
    {
        if(timer.timerEvent(animationSpeed) && currentSprite != sprites.size() - 1)
        {
            currentSprite = 0;
            timer.resetTimer();
        }
        else if(timer.isTimerReady(animationSpeed) && currentSprite == sprites.size() - 1)
        {
            currentSprite = 0;
            currentSprite++;
        }
    }

    private void playAnimation()
    {
        if(timer.timerEvent(animationSpeed) && currentSprite != sprites.size() - 1 && !isDestroyAfterAnim())
        {
            play = false;
            currentSprite = 0;
        }
        else if(timer.timerEvent(animationSpeed) && currentSprite == sprites.size() - 1 && isDestroyAfterAnim())
        {
            sprites = null;
        }
        else if(timer.timerEvent(animationSpeed) && currentSprite != sprites.size() - 1)
        {
            currentSprite++;
        }
    }


    public byte getCurrentSprite()
    {
        return currentSprite;
    }

    public void setCurrentSprite(byte currentSprite)
    {
        this.currentSprite = currentSprite;
    }

    public boolean isLoop()
    {
        return loop;
    }

    public void setLoop(boolean loop)
    {
        this.loop = loop;
    }

    public boolean isSpriteAnimDestroyed()
    {
        if(sprites == null)
        {
            return true;
        }

        return false;
    }


    public void addSprite(BufferedImage spriteMap, int xPos, int yPos, int width, int height)
    {
        sprites.add(spriteMap.getSubimage(xPos, yPos, width, height));
    }

    public void PlayerAnimation(boolean play, boolean destroyAfterAnim)
    {
        this.play = play;
        this.destroyAfterAnim = destroyAfterAnim;
    }

    public double getxPos()
    {
        return xPos;
    }

    public void setxPos(double xPos)
    {
        this.xPos = xPos;
    }

    public double getyPos()
    {
        return yPos;
    }

    public void setyPos(double yPos)
    {
        this.yPos = yPos;
    }

    public boolean isDestroyAfterAnim()
    {
        return destroyAfterAnim;
    }

    public void setDestroyAfterAnim(boolean destroyAfterAnim)
    {
        this.destroyAfterAnim = destroyAfterAnim;
    }
}
