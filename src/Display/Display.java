package Display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private String name;
    private int width, height;

    public Display(String name, int width, int height){
        this.name = name;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(name);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        addCanvasToFrame();
        frame.pack();
    }

    private void addCanvasToFrame(){
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        frame.add(canvas);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
