
/**
 * Write a description of Humidity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Humidity {
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        // defining variables
        CSVRecord lowestHum = null;
        // Loop through the records in the csv file
        for (CSVRecord tempRecord : parser){
            lowestHum = compareAndGet(lowestHum, tempRecord);
        }
        return lowestHum;
    }
    
    public String fileWithLowestHumidity(){
        // Defining variables
        CSVRecord lowestHum = null;
        String fileWithLowestHum = "";
        DirectoryResource dr = new DirectoryResource();
        // Iterate over the files
        for (File f : dr.selectedFiles()){
            // Create FileResource
            FileResource fr = new FileResource(f);
            // Get lowest Humidity
            CSVRecord currLowestHum = lowestHumidityInFile(fr.getCSVParser());
            lowestHum = compareAndGet(lowestHum, currLowestHum);
            // Getting name of file with lowest humidity
            if (lowestHum.get("Humidity").equals("N/A") == false &&
                    currLowestHum.get("Humidity").equals("N/A") == false){
                double lowestHumFile = Double.parseDouble(lowestHum.get("Humidity"));
                double currLowestHumFile = Double.parseDouble(currLowestHum.get("Humidity"));
            
                if (currLowestHumFile <= lowestHumFile ){
                fileWithLowestHum = f.toString();
                }
            }
        }
        return fileWithLowestHum;
    }
    
    public CSVRecord compareAndGet(CSVRecord lowestHum, CSVRecord tempRecord){
        // If lowestHum is null and not equal to "N/A"
        if (lowestHum == null && tempRecord.get("Humidity").equals("N/A") == false){
            lowestHum = tempRecord;
        } else {
            String sCurrHum = tempRecord.get("Humidity");
            double currHum = 0.0;
            if (sCurrHum.equals("N/A") == false){
                currHum = Double.parseDouble(sCurrHum);
                double currLowestHum = Double.parseDouble(lowestHum.get("Humidity"));
                // Compare both humidities
                if (currHum < currLowestHum && currHum != -9999){
                    lowestHum = tempRecord;
                }
            }
        }
        return lowestHum;
    }
    
    public void testLowestHumdityInFile(){
        FileResource fr = new FileResource();
        System.out.println("Testing method: lowestHumidiyInFile()");
        CSVRecord mHumidHour = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("Lowest Humidity was "+
                            mHumidHour.get("Humidity")+" at "+
                            mHumidHour.get("DateUTC"));
    }
    
    public void testFileWithLowestHumidity(){
        String lowHumidFile = fileWithLowestHumidity();
        FileResource fr = new FileResource(lowHumidFile);
        CSVRecord lowHumidHour = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("Testing method: fileWithLowestHumidity()");
        
        // Getting the name of file without path
        int fNameIndex = lowHumidFile.indexOf("weather-");
        String fName = lowHumidFile.substring(fNameIndex, lowHumidFile.length());
        
        // Printing result
        System.out.println("Lowest Humid day was in file "+fName);
        System.out.println("Lowest Humidity on that day was "+
                            lowHumidHour.get("Humidity")+" at "+
                            lowHumidHour.get("DateUTC"));
        System.out.println("All the Humidities on the lowest humid day were:");
        for(CSVRecord record : fr.getCSVParser()){
            System.out.print(record.get("DateUTC"));
            System.out.println(": "+record.get("Humidity"));
        }
    }
}
