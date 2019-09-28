
/**
 * Write a description of ImageInversion here.
 * 
 * @author yamatokataoka
 * @version September 27th, 2019
 */

import edu.duke.*;
import java.io.File;

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
    
    // add another method called selectAndConvert to handle the batch 
    // processing of files. This method allows the user to select several 
    // files and display the images.
    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource outImage = makeInversion(inImage);
            String newFileName = "inverted-" + inImage.getFileName();
            outImage.setFileName(newFileName);
            outImage.save();
            outImage.draw();
        }
    }
    
    // test makeInversion
    public void testMakeInversion () {
        ImageResource inImage = new ImageResource();
        ImageResource outImage = makeInversion(inImage);
        outImage.draw();
    }
}
