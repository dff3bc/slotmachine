/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author dustine
 */
public class Main extends JFrame{
    
    BufferedImage sprite1;
    BufferedImage sprite2;
    BufferedImage sprite3;
    
    public Main()
    {
        setSize(800,800);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
    }
    
    public static void main(String[] args)
    {
        Main main=new Main();
    }
    
    private void init()
    {
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage spriteSheet=null;
        try {
            spriteSheet = loader.LoadImage("New_Piskel.png");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        SpriteSheet ss = new SpriteSheet(spriteSheet);
        
        sprite1 = ss.GrabSprite(0, 0, 200, 200);
        sprite2 = ss.GrabSprite(200, 0, 200, 200);
        sprite3 = ss.GrabSprite(800, 0, 200, 200);
        
        
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.drawImage(sprite1, 100, 100, null);
        g.drawImage(sprite2, 100, 300, null);
        g.drawImage(sprite3, 100, 500, null);
        repaint();
        
    }
}
