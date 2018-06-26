package World;

import Entity.Pipe;

import java.awt.*;
import java.util.ArrayList;

public class Room {

    private ArrayList<Pipe> pipes;
    private int time = 0;

    public Room(){
        pipes = new ArrayList<Pipe>();

    }

    public void update(){
        time++;
        if(time==100){
            time = 0;
            pipes.add(new Pipe((int)((Math.random()* (600-250))+50)));
//            pipes.add(new Pipe((int)(Math.random()*height)));
        }
        for(int i = 0; i < pipes.size();i++){
            Pipe pipe = pipes.get(i);
            pipe.update();
            if(pipe.getX()<0){
                pipes.remove(pipe);
            }
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < pipes.size();i++){
            Pipe pipe = pipes.get(i);
            pipe.render(g);
        }
    }

    public Pipe getPipe(){
        if(pipes.size()>0) return pipes.get(0);
        return null;
    }
}
