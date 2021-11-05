import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sb = new StringBuilder();
        for (int i=whichSlice; i<message.length(); i+=totalSlices){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker ccr = new CaesarCracker(mostCommon);
        for(int i=0; i<key.length; i++){
            String currEncrypt = sliceString(encrypted, i, klength);
            int currKey = ccr.getKey(currEncrypt);
            key[i] = currKey;
        }
        return key;
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> set = new HashSet();
        for (String line : fr.lines()){
            set.add(line.toLowerCase());
        }
        return set;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        String[] splitM = message.split("\\W+");
        int realWords = 0;
        for (int i=0; i<splitM.length; i++){
            if(dictionary.contains(splitM[i].toLowerCase())){
                realWords ++;
            }
        }
        return realWords;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int realWords = 0;
        char mostCommon = 'e';
        String finalDecrypt = "";
        for(int i=0; i<encrypted.length(); i++){
            int[] keyLength = tryKeyLength(encrypted, i, mostCommon);
            VigenereCipher vc = new VigenereCipher(keyLength);
            String decrypted = vc.decrypt(encrypted);
            int currRealWords = countWords(decrypted, dictionary);
            if (currRealWords > realWords){
                finalDecrypt = decrypted;
            }
        }
        return finalDecrypt;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    
}
