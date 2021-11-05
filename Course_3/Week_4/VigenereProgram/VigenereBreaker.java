import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String sliced = "";
        for (int i=whichSlice; i<message.length(); i+=totalSlices){
            sliced += message.charAt(i);
        }
        return sliced;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] keyList = new int[klength];
        //WRITE YOUR CODE HERE;
        for (int i=0; i<klength; i++){
            String currEncrypt = sliceString(encrypted, i, klength);
            CaesarCracker ccr = new CaesarCracker(mostCommon);
            keyList[i] = ccr.getKey(currEncrypt);
        }
        return keyList;
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
        for (String word: splitM){
            if(dictionary.contains(word.toLowerCase())){
                realWords ++;
            }
        }
        return realWords;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int realWords = 0;
        String finalDecrypt = "";
        int keyLength = 0;
        for(int i=1; i<encrypted.length(); i++){
            int[] keyList = tryKeyLength(encrypted, i, 'e');
            VigenereCipher vc = new VigenereCipher(keyList);
            String decrypted = vc.decrypt(encrypted);
            int currRealWords = countWords(decrypted, dictionary);
            if (currRealWords > realWords){
                finalDecrypt = decrypted;
                realWords = currRealWords;
                keyLength = i;
            }
        }
        System.out.println("Message contains " + realWords + " valid words from dictionary");
        System.out.println("Message decoded with keylength of " + keyLength+"!\n\n");
        return finalDecrypt;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String message = fr.asString();
        FileResource dictFr = new FileResource("dictionaries/English");
        HashSet<String> dict = readDictionary(dictFr);
        String decrypted = breakForLanguage(message, dict);
        System.out.println("Please Wait....");
        System.out.println("DECRYPTED MESSAGE:\n"+decrypted);
    }
    
}
