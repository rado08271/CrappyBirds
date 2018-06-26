package Game;

import Display.Display;
import Entity.Pipe;
import Entity.Player;
import Input.MouseInput;
import States.GameState;
import States.State;
import World.Room;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Game implements Runnable {
    private Display display;
    private int width, height;
    private int idx;
    public String title;
    public static int ticks;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //states
    private static State gameState;

    //mouse
    private MouseInput mouse;

    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        mouse = new MouseInput();
    }

    private void init(){
        display = new Display(title,width,height);
        display.getFrame().addMouseListener(mouse);
        display.getCanvas().addMouseListener(mouse);

        gameState = new GameState(gameState);

    }

    private void update(){
        //generating random number
        if(gameState != null){
            gameState.update();
        }

    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);

        //draw
        if(gameState != null){
            gameState.render(g);
        }


        //end
        bs.show();
        g.dispose();
    }

    //gameLOOP
    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1e9 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                update();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1e9){
//                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public synchronized void start(){
        if(running)return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
