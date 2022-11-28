package com.space.Display;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1L;

    public static void main(String[] args)
    {
        Display display = new Display();
        JFrame frame = new JFrame();
        frame.add(display);
        frame.pack();
        frame.setTitle("Space Invaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        display.start();
    }

    private boolean running = false;
    private Thread thread;

    public synchronized void start()
    {
        if(running)
            return;

        running = true;

        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;

        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {throw new RuntimeException(e);}
    }


        public static int WIDTH = 800, HEIGHT = 600;



        public Display()
        {
            this.setSize(WIDTH, HEIGHT);
            this.setFocusable(true);
        }

    @Override
    public void run()
    {
        while(running)
        {
            System.out.println("To dziala");
        }
    }
}

