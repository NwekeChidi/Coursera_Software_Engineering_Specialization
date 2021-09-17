
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class Exports {
    public void tester(String infoCountry){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Testing countryInfo()....");
        System.out.println(countryInfo(parser, infoCountry)+"\n");
        // Reseting parser
        parser = fr.getCSVParser();
        System.out.println("Testing ListExportersTwoProducts()....");
        listExportersTwoProducts(parser, "cotton", "flowers");
        System.out.println();
        // Reseting parser
        parser = fr.getCSVParser();
        System.out.println("Testing numberOfExporters()....");
        System.out.println(numberOfExporters(parser, "cocoa")+"\n");
        // Reseting parser
        parser = fr.getCSVParser();
        System.out.println("Testing bigExporters()....");
        bigExporters(parser, "$999,999,999,999");
        System.out.println("\n\n");
        System.out.println("Testing Completed!");
    }
    
    
    public String countryInfo(CSVParser parser, String country){
        String output = "NOT FOUND";
        for(CSVRecord info : parser){
            // Check if country is in the data
            String checkCountry = info.get("Country");
            String export = "";
            String exportValue = "";
            if (checkCountry.contains(country)){
                // Get countries' export
                export = info.get("Exports");
                // Get countries' export value
                exportValue = info.get("Value (dollars)");
                // get output
                output = country+" : "+export+" : "+exportValue;
                return output;
            }
        }
        return output;
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1,
                                            String exportItem2){
           
        // Loop through the lines in the csv file
        for (CSVRecord record : parser){
            // Get export items
            String exports = record.get("Exports");
            // Check if both export items are contained in exports
            if (exports.contains(exportItem1) && exports.contains(exportItem2)){
                // get the country
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int output = 0;
        // Loop through lines in the csv file
        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            // check if exportItem is contained in exports
            if (exports.contains(exportItem)){
                output += 1;
            }
        }
        return output;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        // Loop through lines in csv file
        for (CSVRecord record : parser){
            String exportValue = record.get("Value (dollars)");
            // Compare exportValue with amount
            if (exportValue.length() > amount.length()){
                String country = record.get("Country");
                System.out.println(country+" "+exportValue);
            }
        }
    }
}
