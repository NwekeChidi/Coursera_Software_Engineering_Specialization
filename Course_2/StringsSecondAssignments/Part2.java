
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String strA, String strB){
        int startIndex = strB.indexOf(strA);
        int count = 0;
        int currIndex = 0;
        while (startIndex != -1){
            count += 1;
            currIndex = startIndex + strA.length();
            startIndex = strB.indexOf(strA, currIndex);
        }
        return count;
    }
    
    public void testHowMany(){
        // case 1
        System.out.println("Case 1");
        String strA = "GAA";
        String strB = "ATGAACGAATTGAATC";
        System.out.println("Checking how many times "+strA+" occured in "+strB);
        int output = howMany(strA, strB);
        System.out.println("Answer :" + output);
        System.out.println();
        
        // case 2
        System.out.println("Case 2");
        strA = "AA";
        strB = "ATAAAA";
        System.out.println("Checking how many times "+strA+" occured in "+strB);
        output = howMany(strA, strB);
        System.out.println("Answer :" + output);
        System.out.println();
        
        // case 3
        System.out.println("Case 3");
        strA = "B";
        strB = "ATAAAA";
        System.out.println("Checking how many times "+strA+" occured in "+strB);
        output = howMany(strA, strB);
        System.out.println("Answer :" + output);
        System.out.println();
    }
}
