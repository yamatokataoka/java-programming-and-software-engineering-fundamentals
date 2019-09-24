
/**
 * Write a description of BatchGrayscale here.
 * 
 * @author yamatokataoka
 * @version September 25th, 2019
 */

import edu.duke.*;

public class BatchGrayscale {
    public ImageResource makeGray (ImageResource inImage) {
        // create blank image
        ImageResource outImage = new ImageResource(inImage.getWidth()
                                                    , inImage.getHeight());
        // convert RGB color into grayscale for each pixel
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getGreen() 
                            + inPixel.getBlue()) / 3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }
    
    // write testing method for makeGray
}
