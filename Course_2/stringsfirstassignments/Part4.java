
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class Part4 {
    public void getYoutubeLink(String url){
        // This method reads the lines from a file at a given url location and
        //prints the youtube links
        
        System.out.println("Processing command---");
        URLResource url1 = new URLResource(url);
        System.out.println(url1);
        String output = "";
        for (String s : url1.words()){
            // Check for "youtube.com" in line
            s = s.toLowerCase();
            int assertYoutube = s.indexOf("youtube.com");
            if (assertYoutube >= 0){
                int startIndex = s.indexOf("\"");
                int endIndex = s.indexOf("\"", startIndex+1);
                output = output.substring(startIndex, endIndex+1);
                System.out.println(output);
            } else {
                System.out.println("No YouTube links in url");
            }
        }
        System.out.println("Process Complete!");
    }
    
    public void testing(){
        
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html/";
        System.out.println("YouTube links in url: ");
        getYoutubeLink(url);
    }
    
    public static void main(){
        Part4 url = new Part4();
        url.testing();
    }
}
