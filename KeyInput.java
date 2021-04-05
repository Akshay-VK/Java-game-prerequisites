package com.akshayvk.firstgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler){
        this.handler = handler;
        for(int i = 0; i < keyDown.length;i++){
            keyDown[i] = false;
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        //System.out.println("p: "+key);

        for(int i = 0; i < handler.object.size();i++){
            GameObject tempObj = handler.object.get(i);
            if(tempObj.getId() == ID.Player){
                if(key == KeyEvent.VK_W){
                    tempObj.setVelY(-5);
                    keyDown[0] = true;
                }
                else if(key == KeyEvent.VK_A){
                    tempObj.setVelX(-5);
                    keyDown[1] = true;
                }
                else if(key == KeyEvent.VK_S){
                    tempObj.setVelY(+5);
                    keyDown[2] = true;
                }
                else if(key == KeyEvent.VK_D){
                    tempObj.setVelX(+5);
                    keyDown[3] = true;
                }
            }

        }

        if(key == KeyEvent.VK_ESCAPE)
            System.exit(1);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        //System.out.println("p: "+key);

        for(int i = 0; i < handler.object.size();i++){
            GameObject tempObj = handler.object.get(i);
            if(tempObj.getId() == ID.Player){
                if(key == KeyEvent.VK_W){
                    //tempObj.setVelY(0);
                    keyDown[0] = false;
                }
                else if(key == KeyEvent.VK_A){
                    //tempObj.setVelX(0);
                    keyDown[1] = false;
                }
                else if(key == KeyEvent.VK_S){
                    //tempObj.setVelY(0);
                    keyDown[2] = false;
                }
                else if(key == KeyEvent.VK_D){
                    //tempObj.setVelX(0);
                    keyDown[3] = false;
                }

                if(!keyDown[0] && !keyDown[3])
                    tempObj.setVelY(0);

                if(!keyDown[1] && !keyDown[2])
                    tempObj.setVelX(0);


            }

        }
    }
}
