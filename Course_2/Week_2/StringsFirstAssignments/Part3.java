
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public boolean twoOccurrences(String strA, String strB){
        // This method returns true if strA appears at least twice in strB,
        //otherwise it returns false
        
        int lenStrA = strA.length();
        int firstIndex = strB.indexOf(strA);
        int secondIndex = strB.indexOf(strA, firstIndex+lenStrA);
        System.out.println("The strings given are : " + strA + " " + strB);
        
        if ( (firstIndex + secondIndex) > firstIndex ){
            return true;
        } else {
            return false;
        }
    }
    
    public void testing(){
        System.out.println("Testing Method: 'twoOcurrences'");
        System.out.println();
        //Case 1
        System.out.println("Case 1");
        String strA = "a";
        String strB = "Banana";
        boolean output = twoOccurrences(strA, strB);
        System.out.println("There are at least two occurences of " + strA + " in " + strB + " : " + output);
        System.out.println();
        
        //Case 2
        System.out.println("Case 2");
        strA = "by";
        strB = "There is a cat by the abby";
        output = twoOccurrences(strA, strB);
        System.out.println("There are at least two occurences of " + strA + " in " + strB + " : " + output);
        System.out.println();
        
        //Case 3
        System.out.println("Case 3");
        strA = "atg";
        strB = "ctgtatgta";
        output = twoOccurrences(strA, strB);
        System.out.println("There are at least two occurences of " + strA + " in " + strB + " : " + output);
        System.out.println();
        
        System.out.println("Testing Method: 'lastPart'");
        System.out.println();
        String result = "";
        //Case 1
        System.out.println("Case 1");
        strA = "by";
        strB = "Frisbyballing";
        result = lastPart(strA, strB);
        System.out.println(result);
        System.out.println();
        
        //Case 2
        System.out.println("Case 2");
        strA = "zoo";
        strB = "Forest";
        result = lastPart(strA, strB);
        System.out.println(result);
        System.out.println();
        
    }
    
    public String lastPart(String strA, String strB){
        // This method finds the first occurrence of strA in strB,
        //and returns the part of strB that follows strA
        int endIndex = strB.length();
        int extraStr = strA.length();
        int startIndex = strB.indexOf(strA);
        if (startIndex == -1){
            return strB;
        } else {
            String result = strB.substring(startIndex+extraStr, endIndex);
            return "The part of the string after " + strA + " in " + strB + " is " + result;
        }
    }
}
