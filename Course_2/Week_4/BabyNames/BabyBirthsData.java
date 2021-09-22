
/**
 * Write a description of BabyBirthsData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirthsData {
    public void displayData (){
        // create file resource
        FileResource fr = new FileResource();
        // print supposed header
        System.out.println("Name\t\tGender\t\tNumber");
        // iterate through records in file
        for (CSVRecord record : fr.getCSVParser(false)){
            System.out.println(record.get(0)+"\t\t"+record.get(1)+"\t\t"+
                                record.get(2));
        }
        
        // get total births
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(0));
            totalBirths += numBorn;
            if (rec.get(1).equals("F")){
                totalGirls += numBorn;
            } else {
                totalBoys += numBorn;
            }
        }
        System.out.println("Total births = "+totalBirths);
        System.out.println("Total boys = "+totalBoys);
        System.out.println("Total girls = "+totalGirls);
    }
}
