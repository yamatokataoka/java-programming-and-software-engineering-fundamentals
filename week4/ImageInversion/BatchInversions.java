
/**
 * Write a description of ImageInversion here.
 * 
 * @author yamatokataoka
 * @version September 27th, 2019
 */

import edu.duke.*;

public class BatchInversions {
    // how to create a new image that is the inverse of another image.
    public ImageResource makeInversion (ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth()
                                                , inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int newR = 255 - inPixel.getRed();
            int newG = 255 - inPixel.getGreen();
            int newB = 255 - inPixel.getBlue();
            pixel.setRed(newR);
            pixel.setGreen(newG);
            pixel.setBlue(newB);
        }
        return outImage;
    }
    
    // test makeInversion
}
