/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
