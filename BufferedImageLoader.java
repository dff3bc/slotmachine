//Copyright 2016, Dustin Evans, All rights reserved.
package slotmachine;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author dustine
 */
public class BufferedImageLoader{
    
    public BufferedImage LoadImage(String path) throws IOException
    {
        URL url = this.getClass().getResource(path);
        BufferedImage img = ImageIO.read(url);
        return img;
    }
}
