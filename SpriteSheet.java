//Copyright 2016, Dustin Evans, All rights reserved.

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
