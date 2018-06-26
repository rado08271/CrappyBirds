package Entity;

import Input.MouseInput;
import World.Room;

import java.awt.*;

public class Player {
    private float velocity;
    private float GRAVITY;
    private int x,y;
    private int speed;
    private Room room;

    //mouse ipnut
    private MouseInput mouse;

    public Player(){
        GRAVITY = 0.23f;
        velocity = 0;
        x = 800/3;
        y = 600/2;
    }

    public void update(){
        if(mouse.getIsClicked()) {
            y -= 15;
            velocity = 0;
        }else{
            velocity += GRAVITY;
            y += (int) velocity;
        }
    }

    public void render(Graphics g){
        g.fillRect(x,y,32,32);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
