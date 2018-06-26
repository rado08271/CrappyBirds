package States;

import Entity.Pipe;
import Entity.Player;
import World.Room;

import java.awt.*;

public class GameState extends State {

    private Room room;
    public Player player;

    public GameState(State state) {
        super(state);
        room = new Room();
        player = new Player();
    }

    @Override
    public void update() {
        if(collisions()){
            //gameOver
            return;
        }
        player.update();
        room.update();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        room.render(g);

    }

    //FIXME want to stop 32 pixels ahead of pipe collision..
    //TODO inside pipe and up
    private boolean collisionWithPipe(){
        //collision
        if(room.getPipe() != null) {
            if (((player.getX() == room.getPipe().getX()) && (player.getY() <= room.getPipe().getY() || player.getY() >= (room.getPipe().getY() + 200))) //||
//                 (player.getY() == room.getPipe().getY()) && (player.getX() >= room.getPipe().getX() || player.getX() >= (room.getPipe().getX() + 40)) ||
//                 (player.getY() == room.getPipe().getY()+ 200) && (player.getX() >= room.getPipe().getX() || player.getX() >= (room.getPipe().getX() + 40))
               ) {
                return true;
            }
        }
        return false;
    }

    private boolean collideWithBorders(){
        if(player.getY() > 600-32||player.getY() < 0+32){
            return true;
        }
        return false;
    }

    public boolean collisions(){
        if(collideWithBorders() || collisionWithPipe()){
            return true;
        }
        return false;
    }
}
