package com.akshayvk.firstgame;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serial;
import java.util.Random;

public class Main extends Canvas implements Runnable{

    @Serial
    private static final long serialVersionUID = 5538633780946597121L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
    private Thread thread;
    private boolean running  = false;

    private final Handler handler;

    private HUD hud;

    private Spawn spawner;

    private Random r;

    int fps;

    private static double deltaTime = 0;

    public static double getDeltaTime(){
        return deltaTime;
    }

    public Main(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        hud = new HUD();
        spawner = new Spawn(handler,hud);


        new Window(WIDTH, HEIGHT, "First game!", this);

        fps= 0;

        r = new Random();

        handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player, handler));

        for(int i = 0; i < 1;i++){

            handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
        }
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ ns;
            //System.out.println(delta);
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: "+frames);
                frames=0;
            }
            fps = frames;
            deltaTime = delta;
        }
        stop();
    }

    public static float clamp(float val, float min, float max){
        if(val <= min)
            return val = min;
        else if(val >= max)
            return val = max;
        else
            return val;
    }

    private void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.white);
        g.drawString("FPS: "+fps,WIDTH-75,10);
        handler.render(g);

        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Main();
    }
}

