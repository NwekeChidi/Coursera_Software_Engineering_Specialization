import java.util.*;
import java.io.*;
import edu.duke.*;

public class VigenereBreaker {
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE;
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
        char mostCommon = mostCommonCharIn(dictionary);
        for(int i=1; i<100; i++){
            int[] keyList = tryKeyLength(encrypted, i, mostCommon);
            VigenereCipher vc = new VigenereCipher(keyList);
            String decrypted = vc.decrypt(encrypted);
            int currRealWords = countWords(decrypted, dictionary);
            if (currRealWords > realWords){
                finalDecrypt = decrypted;
                realWords = currRealWords;
                keyLength = i;
            }
        }
        System.out.println("Message contains "+realWords+" valid words from dictionary");
        System.out.println("Message decoded with key of length "+keyLength+"!\n\n");
        return finalDecrypt;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        int mostCommon = 0;
        char mostCommonChar = 'a';
        HashMap<Character, Integer> charMap = new HashMap<Character,Integer>();
        for (String word : dictionary){
            for (int i=0; i<word.length(); i++){
                char letter = word.charAt(i);
                if (charMap.containsKey(letter)){
                    charMap.put(letter, charMap.get(letter)+1);
                } else {
                    charMap.put(letter, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> set : charMap.entrySet()){
            if ( mostCommon < set.getValue()){
                mostCommonChar = set.getKey();
                mostCommon = set.getValue();
            }
        }
        return mostCommonChar;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> languages){
        int realWords = 0;
        String dLang = "";
        String decrypted = "";
        for (String language : languages.keySet()){
            HashSet<String> dictionary = languages.get(language);
            decrypted = breakForLanguage(encrypted, dictionary);
            int currRealWords = countWords(decrypted, dictionary);
            if (realWords < currRealWords){
                realWords = currRealWords;
                dLang = language;
            }
        }
        System.out.println("Message Decrypted in "+dLang+" language");
        System.out.println("DECRYPTED MESSAGE:");
        System.out.println(decrypted);
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource("messages/secretmessage4.txt");
        String message = fr.asString();
        System.out.println("Select Dictionary Files....");
        DirectoryResource dictDr = new DirectoryResource();
        HashMap<String,HashSet<String>> languages = new HashMap<String,HashSet<String>>();
        for (File f : dictDr.selectedFiles()){
            String currLang = f.getName();
            FileResource currFr = new FileResource(f);
            HashSet<String> currDict = readDictionary(currFr);
            System.out.println("Completed Reading "+currLang+" Dictionary");
            languages.put(currLang, currDict);
        }
        System.out.println("\nPlease Wait....\n");
        breakForAllLangs(message, languages);
    }
    
}
