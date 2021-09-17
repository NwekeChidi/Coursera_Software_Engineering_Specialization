
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Part2 {
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        // defining variables
        CSVRecord coldestTemp = null;
        // Loop through the records in the csv file
        for (CSVRecord tempRecord : parser){
            coldestTemp = compareAndGet(coldestTemp, tempRecord);
        }
        return coldestTemp;
    }
    
    public String fileWithColdestTemperature(){
        // Defining variables
        CSVRecord coldestTemp = null;
        String fileWithColdestTemp = "";
        DirectoryResource dr = new DirectoryResource();
        // Iterate over the files
        for (File f : dr.selectedFiles()){
            // Create FileResource
            FileResource fr = new FileResource(f);
            // get coldest temperature
            CSVRecord currColdest = coldestHourInFile(fr.getCSVParser());
            coldestTemp = compareAndGet(coldestTemp, currColdest);
            // Getting name of file with coldest temperature
            double coldestTempFile = Double.parseDouble(coldestTemp.get("TemperatureF"));
            double currColdestTempFile = Double.parseDouble(currColdest.get("TemperatureF"));
            if (currColdestTempFile <= coldestTempFile){
                fileWithColdestTemp = f.toString();
            }
        }
        return fileWithColdestTemp;
    }
    
    public CSVRecord compareAndGet(CSVRecord coldestTemp, CSVRecord tempRecord){
        // If coldestTemp is null
        if (coldestTemp == null){
            coldestTemp = tempRecord;
        } else {
            double currTemp = Double.parseDouble(tempRecord.get("TemperatureF"));
            double currColdestTemp = Double.parseDouble(coldestTemp.get("TemperatureF"));
            // Compare both temperatures
            if (currTemp < currColdestTemp && currTemp != -9999){
                coldestTemp = tempRecord;
            }
        }
        return coldestTemp;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        System.out.println("Testing method: coldestHourInFile()");
        CSVRecord coldestHour = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest hour in file was "+
                            coldestHour.get("TemperatureF")+" at "+
                            coldestHour.get("TimeEST"));
    }
    
    public void testFileWithColdestTemperature(){
        String coldestFile = fileWithColdestTemperature();
        FileResource fr = new FileResource(coldestFile);
        CSVRecord coldestHour = coldestHourInFile(fr.getCSVParser());
        System.out.println("Testing method: fileWithColdestTemperature()");
        
        // Getting the name of file without path
        int fNameIndex = coldestFile.indexOf("weather-");
        String fName = coldestFile.substring(fNameIndex, coldestFile.length());
        
        // Printing result
        System.out.println("Coldest day was in file "+fName);
        System.out.println("Coldest temperature on that day was "+
                            coldestHour.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        for(CSVRecord record : fr.getCSVParser()){
            System.out.print(record.get("DateUTC"));
            System.out.println(": "+record.get("TemperatureF"));
        }
    }
}
