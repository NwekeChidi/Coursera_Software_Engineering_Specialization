
/**
 * Write a description of BatchInversion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class BatchInversions {
    // Get an Image and invert
    public ImageResource invertImg(ImageResource inImage) {
        // Create a blank image of same size
        ImageResource outImage = new ImageResource(inImage.getWidth(),
                                                    inImage.getHeight());
        // Iterate through pixels in the image
        for (Pixel pixel : outImage.pixels()) {
            // get corresponding pixel from inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            // get the inversion of the RGB values of the pixel
            int redInv = 255 - inPixel.getRed();
            int greenInv = 255 - inPixel.getGreen();
            int blueInv = 255 - inPixel.getBlue();
            // set the RGB values of pixel to the inversions
            pixel.setRed(redInv);
            pixel.setBlue(blueInv);
            pixel.setGreen(greenInv);
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
            ImageResource inversion = invertImg(ir);
            // create an instance of the ImageSaver class
            ImageSaver saver = new ImageSaver();
            // save converted Image
            saver.doSave(f, ir, inversion, "inverted-");
            // dray converted image to canvas
            inversion.draw();
        }
    }
    
    public void testInversion() {
        ImageResource ir = new ImageResource();
        ImageResource inversion = invertImg(ir);
        inversion.draw();
    }
}
