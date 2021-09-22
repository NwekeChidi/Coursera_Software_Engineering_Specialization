
/**
 * Write a description of BabyBirthsData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;;
import java.io.*;

public class BabyNames {
    // Defining path and path_ext
    String path = "us_babynames/us_babynames_by_year/yob";
    String path_ext = ".csv";
    public void dataOverview() {
        BabyBirthsData overview = new BabyBirthsData();
        overview.displayData();
    }
    
    public void tester() {
        // testing getRank method
        System.out.println();
        System.out.println("Starting new test session");
        System.out.println("Testing the 'getRank()' method...");
        int rank = getRank(1960, "Emily", "F");
        System.out.println(rank);
        System.out.println("Testing the 'getRank()' method...");
        rank = getRank(1971, "Frank", "M");
        System.out.println(rank);
        
        // testing getName method
        System.out.println();
        System.out.println("Testing the 'getName()' method...");
        String name = getName(1980, 350, "F");
        System.out.println(name);
        // testing getName method
        System.out.println();
        System.out.println("Testing the 'getName()' method...");
        name = getName(1982, 450, "M");
        System.out.println(name);
        
        // testing whatIsNameInYear
        System.out.println();
        System.out.println("Testing the 'whatIsNameInYear()' method...");
        whatIsNameInYear("Susan", 1972, 2014, "F");
        // testing whatIsNameInYear
        System.out.println();
        System.out.println("Testing the 'whatIsNameInYear()' method...");
        whatIsNameInYear("Owen", 1974, 2014, "M");
        
        // testing yearOfHighestRank
        System.out.println();
        System.out.println("Testing the 'yearOfHighestRank()' method...");
        int yearHigh = yearOfHighestRank("Genevieve", "F");
        System.out.println(yearHigh);
        // testing yearOfHighestRank
        System.out.println();
        System.out.println("Testing the 'yearOfHighestRank()' method...");
        yearHigh = yearOfHighestRank("Mich", "M");
        System.out.println(yearHigh);
        
        // testing getAverageRank
        System.out.println();
        System.out.println("Testing the 'getAverageRank()' method...");
        double avgRank = getAverageRank("Susan", "F");
        System.out.println(avgRank);
        // testing getAverageRank
        System.out.println();
        System.out.println("Testing the 'getAverageRank()' method...");
        avgRank = getAverageRank("Robert", "M");
        System.out.println(avgRank);
        
        // testing getTotalBirthsRankedHigher
        System.out.println();
        System.out.println("Testing the 'getTotalBirthsRankedHigher()' method...");
        int totalRankHigher = getTotalBirthsRankedHigher(1990, "Emily", "F");
        System.out.println(totalRankHigher);
        // testing getTotalBirthsRankedHigher
        System.out.println();
        System.out.println("Testing the 'getTotalBirthsRankedHigher()' method...");
        totalRankHigher = getTotalBirthsRankedHigher(1990, "Drew", "M");
        System.out.println(totalRankHigher);
    }
    
    public void testYearOfHighestRank() {
        // testing yearOfHighestRank
        System.out.println();
        System.out.println("Testing the 'yearOfHighestRank()' method...");
        int yearHigh = yearOfHighestRank("Mich", "M");
        System.out.println(yearHigh);
    }
    
    public int getRank (int year, String name, String gender) {
        // get file
        FileResource fr = new FileResource(path+new Integer(year).toString()+
                                            path_ext);
        int finalRank = 0;
        int currRank = 0;
        // check if name is not in file
        for (CSVRecord rec : fr.getCSVParser(false)){
            // get rank of the given name
            if (rec.get(1).equals(gender)==true){
                if (rec.get(0).equals(name)==true) {
                    finalRank = currRank+1;
                    return finalRank;
                } else {
                    // increase rank if given name is not in record
                    currRank += 1;
                }
            } else {
                // return rank as -1 if name and gender not in record
                finalRank = -1;
            }
        }
        return finalRank;
    }
    
    public String getName (int year, int rank, String gender) {
        // get file
        FileResource fr = new FileResource(path+new Integer(year).toString()+
                                            path_ext);
        String name = "NO NAME";
        int currRank = 1;
        // loop through the file
        for (CSVRecord rec : fr.getCSVParser(false)) {
            // check if gender is in current row
            if (rec.get(1).equals(gender)==true) {
                // check if rank equals currRank
                if (rank == currRank) {
                    name = rec.get(0);
                    return name;
                } else {
                    currRank += 1;
                }
            }
        }
        return name;
    }
    
    public void whatIsNameInYear (String name, int year,
        int newYear, String gender) {
        // get rank using year
        int rank = getRank(year, name, gender);
        // get name for newYear
        String newName = getName(newYear, rank, gender);
        // get pronoun for output
        String pN = "he";
        if (gender.equals("F")==true){pN="she";}
        System.out.println(name+" born in "+year+" would be "+newName+
                            " if "+pN+" was born in "+newYear+".");
    }
    
    public int yearOfHighestRank(String name, String gender) {
        // create a directory of files
        DirectoryResource dr = new DirectoryResource();
        // define variables
        int highestRankYear = -1;
        int currRank = 0;
        int highestRank = 0;
        // looping through files to get the ranks
        for ( File f : dr.selectedFiles()){
           // create a FileResource
           FileResource fr = new FileResource(f);
           // get year from filename
           String fileName = f.toString();
           int startIndex = fileName.indexOf("yob")+3;;
           int year = Integer.parseInt(fileName.substring(startIndex, startIndex+4));
           // get currRank
           currRank = getRank(year, name, gender);
           // set highestRankYear to currRank if = -1
           if (highestRankYear == -1) {
               highestRankYear = year;
            }
           // check if currRank > highestRank
           if (currRank < highestRank) {
               // set highestRank to currRank
               highestRank = currRank;
               // set highestRankYear to year
               highestRankYear = year;
           }
        }
        return highestRankYear;
    }
    
    public double getAverageRank(String name, String gender) {
        // create a directory of files
        DirectoryResource dr = new DirectoryResource();
        // define variables
        double totalRank = 0.0;
        int numRank = 0;
        double avgRank = 0.0;
        // looping through files to get the ranks
        for ( File f : dr.selectedFiles()) {
           // create a FileResource
           FileResource fr = new FileResource(f);
           // get year from filename
           String fileName = f.toString();
           int startIndex = fileName.indexOf("yob")+3;;
           int year = Integer.parseInt(fileName.substring(startIndex, startIndex+4));
           // get rank
           int rank = getRank(year, name, gender);
           // increment totalRank and numRank if rank != -1
           if ( rank != -1 ) {
               totalRank += rank;
               numRank += 1;
           }
        }
        if (totalRank == 0.0){return -1;}
        avgRank = totalRank / numRank;
        return avgRank;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        // create FileResource
        FileResource fr = new FileResource(path+new Integer(year).toString()+
                                            path_ext);
        // define variables
        int totalRankedHigher = 0;
        int count = 1;
        // get rank
        int rank = getRank(year, name, gender);
        if ( rank == -1 ){return -1;}
        // loop through file
        for (CSVRecord rec : fr.getCSVParser(false)){
            // considering records with given gender
            if ( rec.get(1).equals(gender)==true ){
                if ( rec.get(0).equals(name)==false &&
                    count < rank ){
                    int incr = Integer.parseInt(rec.get(2));
                    totalRankedHigher += incr;
                    count += 1;
                }
            }
        }
        return totalRankedHigher;
    }
}
