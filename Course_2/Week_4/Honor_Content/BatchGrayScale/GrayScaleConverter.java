
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
    // Get an Image and convert to grayscale
    public ImageResource makeGray(ImageResource inImage) {
        // Create a blank image of same size
        ImageResource outImage = new ImageResource(inImage.getWidth(),
                                                    inImage.getHeight());
        // Iterate through pixels in the image
        for (Pixel pixel : outImage.pixels()) {
            // get corresponding pixel from inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            // get the average of the RGB values of the pixel
            int average = (inPixel.getRed() + inPixel.getBlue() + 
                            inPixel.getGreen()) / 3;
            // set the RGB values of pixel to the average
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }
        return outImage;
    }
    
    // Method to select images and convert to grayscale
    public void selectAndConvert() {
        // create directory
        DirectoryResource dr = new DirectoryResource();
        // iterate through resource to get files
        for (File f : dr.selectedFiles()) {
            // get Image resource from current file
            ImageResource ir = new ImageResource(f);
            // convert image to grayScale
            ImageResource gray = makeGray(ir);
            // create an instance of the ImageSaver class
            ImageSaver saver = new ImageSaver();
            // save converted Image
            saver.doSave(f, ir, gray, "gray-");
            // dray converted image to canvas
            gray.draw();
        }
    }
    
    public void testGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
}
