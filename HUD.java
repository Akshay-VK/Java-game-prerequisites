package com.akshayvk.firstgame;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;
    
    public int green = 255;

    private int score = 0;
    private int level = 1;

    public void tick(){
        HEALTH = (int) Main.clamp(HEALTH,0,100);
         green = (int) Main.clamp(green, 0 , 255);

         green = HEALTH/100*255;

         score++;

    }

    public void render(Graphics g){
        g.setColor(Color.gray);

        g.fillRect(15,15,100,20);

        g.setColor(new Color(75, this.green, 0));
        g.fillRect(15,15,HEALTH,20);

        g.setColor(Color.white);
        g.drawRect(15,15,HEALTH,20);

        g.drawString("Score: "+score,15,64);
        g.drawString("Level: "+level,15,80);

    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}
