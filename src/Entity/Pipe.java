
package Entity;

import Game.*;

import java.awt.*;

public class Pipe {
    private int x, y, width;
    private int sWidth = 800, sHeight = 600;
    private int speed = 3;

    public Pipe(int y) {
        this.x = sWidth;
        this.y = y;
        this.width = 40;
    }

    public void update() {
        x -= speed;
    }

    public void render(Graphics g) {
        g.fillRect(x, 0, width, y);
        g.fillRect(x, y + 200, width, sHeight);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
