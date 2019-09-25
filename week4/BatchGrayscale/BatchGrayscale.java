
/**
 * Write a description of BatchGrayscale here.
 * 
 * @author yamatokataoka
 * @version September 25th, 2019
 */

import edu.duke.*;
import java.io.File;

public class BatchGrayscale {
    // For each image, create a new image that is a grayscale version
    // of the original image
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
    
    // Your program should let the user select multiple image files
    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource outImage = makeGray(inImage);
            String fileName = outImage.getFileName();
            String newFileName = "gray-" + fileName;
            outImage.setFileName(newFileName);
            outImage.draw();
            outImage.save();
        }
    }
    
    // For each image, save the grayscale image in a new file with the same
    // filename as the original image, but with the word “gray-” in
    // front of the filename.
    
    
    // write testing method for makeGray
    public void testMakeGray () {
        ImageResource inImage = new ImageResource();
        ImageResource outImage = makeGray(inImage);
        outImage.draw();
    }
}
