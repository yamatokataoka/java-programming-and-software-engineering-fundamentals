import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    // This method returns a String consisting of every totalSlices-th character
    // from message, starting at the whichSlice-th character.
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sliceString = new StringBuilder();
        for (int k=whichSlice; k<message.length(); k+=totalSlices) {
            sliceString.append(message.toCharArray()[k]);
        }
        return sliceString.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        for (int k=0; k<klength; k++) {
            String sliceString = sliceString(encrypted, k, klength);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            key[k] = (cc.getKey(sliceString));
        }
        return key;
    }

    public void breakVigenere () {
        // Create a new FileResource using its default constructor
        // FileResource fr = new FileResource();
        // Use the asString method to read the entire contents of the file
        // into a String.
        // String input = fr.asString();
        // Use the tryKeyLength method to find the key for the message
        // you read in
        // int[] key = tryKeyLength(input, 5, 'e');
        // create a new VigenereCipher, passing in the key that tryKeyLength found
        // VigenereCipher vc = new VigenereCipher(key);
        // use the VigenereCipher’s decrypt method to decrypt the encrypted message.
        // System.out.println(vc.decrypt(input));
        
        // Q2: What is the first line of the file secretmessage1.txt?
        // int[] key = tryKeyLength(input, 4, 'e');
        // VigenereCipher vc = new VigenereCipher(key);
        // System.out.println(vc.decrypt(input));
        
        // Programming Exercise: Unknown Key Length
        // Create a new FileResource using its default constructor
        FileResource frEncrypted = new FileResource();
        // Use that FileResource’s asString method to read the entire
        // contents of the file into a String
        String encrypted = frEncrypted.asString();
        // new FileResource to read from the English dictionary file
        FileResource frDictionary = new FileResource("dictionaries/English");
        // readDictionary method to read the contents of that file into a HashSet of Strings.
        HashSet<String> dictionary = readDictionary(frDictionary);
        // use the breakForLanguage method
        String decrypted = breakForLanguage(encrypted, dictionary);
        System.out.println(decrypted);
    }
    
    // write the public method readDictionary,
    // which has one parameter—a FileResource fr. 
    public HashSet<String> readDictionary (FileResource fr) {
        // make a new HashSet of Strings
        HashSet<String> set = new HashSet<String>();
        // read each line in fr
        for (String line: fr.lines()) {
            // convert that line to lowercase, and put that line into the HashSet
            set.add(line.toLowerCase());
        }
        // return the HashSet representing the words in a dictionary.
        return set;
    }
    
    // write the public method countWords, which has two parameters—a
    // String message, and a HashSet of Strings dictionary.
    public int countWords (String message, HashSet<String> dictionary) {
        int numOfValidWords = 0;
        for (String word: message.split("\\W")) {
            if (dictionary.contains(word.toLowerCase())) {
                numOfValidWords++;
            }
        }
        // return the integer count of how many valid words it found.
        return numOfValidWords;
    }
    
    // write the public method breakForLanguage, which has two parameters—
    // a String encrypted, and a HashSet of Strings dictionary.
    public String breakForLanguage (String encrypted, HashSet<String> dictionary) {
        int largestCount = 0;
        String answer = "";
        //  try all key lengths from 1 to 100 to obtain the best decryption
        for (int k=1; k<=100; k++) {
            int[] key = tryKeyLength(encrypted, k, 'e');
            // decrypt the message
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int numOfValidWords = countWords(decrypted, dictionary);
            // figure out which decryption gives the largest count of real words
            if (numOfValidWords > largestCount) {
                answer = decrypted;
                largestCount = numOfValidWords;
                // Unknown Key Length Q1: What is the key length used to encrypt the file secretmessage2.txt?
                System.out.println(key.length);
                // Unknown Key Length Q2: How many valid words are in the decrypted String?
                System.out.println(numOfValidWords);
            }
        }
        // return that String decryption.
        return answer;
    }
    
    // write the public method mostCommonCharIn, which has one parameter—
    // a HashSet of Strings dictionary.
    public char mostCommonCharIn (HashSet<String> dictionary) {
        // find out which character, of the letters in the English alphabet,
        // appears most often in the words in dictionary.
        HashMap<Character, Integer> map = countWords(dictionary);
        int leargetNum = 0;
        char mostCommonChar = '\0';
        for (char ch: map.keySet()) {
            int num = map.get(ch);
            if (num > leargetNum) {
                leargetNum = num;
                mostCommonChar = ch;
            }
        }
        return mostCommonChar;
    }
    
    // helper method for mostCommonCharIn
    private HashMap<Character, Integer> countWords(HashSet<String> dictionary) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (String word: dictionary) {
            char[] wordArray = word.toLowerCase().toCharArray();
            for (char ch: wordArray) {
                if (map.containsKey(ch)) {
                    int num = map.get(ch);
                    map.put(ch, num+1);
                }
                else {
                    map.put(ch, 1);
                }
            }
        }
        return map;
    }
}
