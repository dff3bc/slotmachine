/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

/**
 *
 * @author dustinevans
 */

import javax.swing.JFrame;

public class Main extends JFrame implements Runnable{
    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    Thread gameloop;

    public static Main instance = null;

    private Main(){
        super();    //construct a new invisible JFrame
        /* Define the frame properties */
        this.setSize(this.WIDTH, this.HEIGHT);
        this.setVisible(true);
                        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static Main getInstance(){
        if (instance == null){
            instance = new Main();
        }
        return instance;
    }
    /* End of singleton code */

    public static void main(String[] args){
        System.out.println("TutorialPath can run!");
        Main.getInstance();
        Main.getInstance().start();
    }


        public void run() {
        Thread current = Thread.currentThread();
        while (current == gameloop) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                //do nothing
                e.printStackTrace();
            }
            //updateGameLogic();
            System.out.println("I'm running: " +                System.currentTimeMillis());
            repaint();  //draw to the screen
            
    }
}

            public void start() {
               gameloop = new Thread(this);
               gameloop.start();
        }

}
