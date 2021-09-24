
/**
 * Write a description of ImageSaver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class ImageSaver {
    public void doSave(File f, ImageResource ir,
                                ImageResource gray, String prefix) {
        // get filename and path
        String fullFileName = f.toString();
        String fname = ir.getFileName();
        // get path
        int endIdx = fullFileName.indexOf(fname);
        String path = fullFileName.substring(0, endIdx);
        // create a new filename for gray images
        String grayName = path+prefix+fname;
        // set new name and save
        gray.setFileName(grayName);
        gray.save();
    }
}
