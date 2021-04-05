package com.akshayvk.firstgame;

import java.awt.*;

public abstract class GameObject {
    protected float x,y;
    protected ID id;
    protected float velX, velY;

    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public void setVelX(float vx){
        this.velX = vx;
    }

    public void setVelY(float vy){
        this.velY = vy;
    }

    public void setId(ID id){
        this.id = id;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public float getVelX(){
        return this.velX;
    }

    public float getVelY(){
        return this.velY;
    }


    public ID getId(){
        return this.id;
    }


}
