
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author yamatokataoka
 * @version October 14th, 2019
 */

import edu.duke.*;

// Create the TestCaesarCipherTwo class
public class TestCaesarCipherTwo {
    // Include the methods halfOfString, countLetters, maxIndex and getKey
    private String halfOfString (String message, int start) {
        String answer = "";
        for (int k = start; k< message.length() ; k+= 2) {
            answer = answer + message.charAt(k);    	
        }
        return answer;
    }
    
    private int[] countLetters (String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public int getKey (String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex (freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        
        return dkey;
    }
    
    private int maxIndex (int[] vals) {
        int maxIndex = 0;
        for (int k=0; k < vals.length; k++) {
            // consider maxIndex so vals[maxIndex] rather than maxIndex
            if (vals[maxIndex] < vals[k]) {
                // And k rather than vals[k]
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    // Write the method breakCaesarCipher that has one String parameter named input.
    public String breakCaesarCipher (String input) {
        // figure out which keys were used to encrypt this message
        String firstHalfOfString = halfOfString(input, 0);
        String secondHalfOfString = halfOfString(input, 1);
        int firstDKey = getKey(firstHalfOfString);
        int secondDKey = getKey(secondHalfOfString);
        // print the two keys found.
        System.out.println("Found keys are " + firstDKey + ", " + secondDKey);
        // create a CaesarCipherTwo object with that key
        CaesarCipherTwo cct = new CaesarCipherTwo(firstDKey, secondDKey);
        // decrypt the message
        String decrypted = cct.decrypt(input);
        return decrypted;
    }
    
    // Write the void method simpleTests that has no parameters.
    // This method should , , , print the encrypted String, and decrypt the encrypted String using
    // the decrypt method.
    public void simpleTests () {
        // read in a file as a String
        FileResource fr = new FileResource();
        String input = fr.asString();
        // create a CaesarCipherTwo object with keys 17 and 3
        CaesarCipherTwo cct = new CaesarCipherTwo(17, 3);
        // encrypt the String using the CaesarCipherTwo object
        String encrypted = cct.encrypt(input);
        // print the encrypted String
        System.out.println(encrypted);
        // decrypt the encrypted String using the decrypt method.
        String decrypted = cct.decrypt(encrypted);
        // print the decrypted String
        System.out.println(decrypted);
        // add a call to breakCaesarCipher on the encrypted String to decrypt it
        // automatically by determining the keys
        decrypted = breakCaesarCipher(encrypted);
        // print the decrypted String.
        System.out.println(decrypted);
    }
}
