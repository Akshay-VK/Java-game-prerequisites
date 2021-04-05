package com.akshayvk.firstgame;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private static final long serialVersionUID = 7442871763199152662L;

    public Window(int width, int height, String title, Main game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));

        frame.setDefaultCloseOperation((JInternalFrame.EXIT_ON_CLOSE));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
