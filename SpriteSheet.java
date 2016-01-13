/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slotmachine;

import java.awt.image.BufferedImage;

/**
 *
 * @author dustine
 */

public class SpriteSheet {
    
    public BufferedImage spritesheet;
    
    public SpriteSheet(BufferedImage bi)
    {
        this.spritesheet=bi;
    }
    
    public BufferedImage GrabSprite(int x, int y, int width, int height)
    {
        BufferedImage sprite = this.spritesheet.getSubimage(x, y, width, height);
        return sprite;
    }
}
