
/**
 * Write a description of BabyBirthsData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirthsData {
    public void displayData (){
        // create file resource
        FileResource fr = new FileResource();
        // print supposed header
        System.out.println("Name\t\tGender\t\tNumber");
        // iterate through records in file
        String columnSpace = "Name            ";
        for (CSVRecord record : fr.getCSVParser(false)){
            // get first column
            String babyName = record.get(0);
            // print first column
            System.out.print(babyName);
            /// formating output
            // get required number of spacing
            int numSpace = columnSpace.length() - babyName.length();
            // print required spaces;
            for (int i=0; i<numSpace; i++){
                System.out.print(" ");
            }
            // print second column
            System.out.println(record.get(1)+"\t\t"+record.get(2));
        }
        
        // get total births
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int boyNames = 0;
        int girlNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("F")){
                totalGirls += numBorn;
                girlNames += 1;
            } else {
                totalBoys += numBorn;
                boyNames += 1;
            }
        }
        System.out.println();
        System.out.println("Total boy names = "+boyNames);
        System.out.println("Total girl names = "+girlNames);
        System.out.println("Total births = "+totalBirths);
        System.out.println("Total boys = "+totalBoys);
        System.out.println("Total girls = "+totalGirls);
    }
}
