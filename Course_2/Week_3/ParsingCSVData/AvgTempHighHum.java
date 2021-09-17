
/**
 * Write a description of AvgTempHighHum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class AvgTempHighHum {
    
    public double averageTemperatureInFile(CSVParser parser){
        // defining variables
        double totalTemp = 0.0;
        double avgTemp = 0.0;
        int numEntry = 0;
        // Loop through the records in the csv file
        for (CSVRecord tempRecord : parser){
            double currTemp = Double.parseDouble(tempRecord.get("TemperatureF"));
            if (currTemp != -9999){
                totalTemp += currTemp;
                numEntry += 1;
            }
        }
        avgTemp = totalTemp/numEntry;
        return avgTemp;
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        // Defining variables
        double avgTemp = 0.0;
        int numEntry = 0;
        double totalTemp = 0.0;
        // Looping through the records in the csv file
        for (CSVRecord record : parser){
            // Get temperature in double and humidity in string for current row
            double currTemp = Double.parseDouble(record.get("TemperatureF"));
            String sCurrHumid = record.get("Humidity");
            // Check if humidity at current row is an actual value
            if (sCurrHumid.equals("N/A") == false){
                double currHumid = Double.parseDouble(sCurrHumid);
                // Comparing currHumid with given value threshold
                if (currHumid >= value && currTemp != -9999){
                    numEntry += 1;
                    totalTemp += currTemp;
                }
            }
        }
        if (totalTemp == 0.0){
            return avgTemp;
        }
        avgTemp = totalTemp/numEntry;
        return avgTemp;
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        System.out.println("Testing method: averageTemperatureInFile()");
        double avgTemp = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is "+avgTemp);
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(int value){
        FileResource fr = new FileResource();
        System.out.println("Testing method: averageTemperatureWithHighHumidityInFile()");
        double avgTemp = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), value);
        if (avgTemp == 0.0){
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average temperature when high Humidity of "+
                                value+" is "+avgTemp);
        }
    }
}
