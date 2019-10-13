
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author yamatokataoka
 * @version October 13th, 2019
 */

import edu.duke.*;

// Create the TestCaesarCipher class
public class TestCaesarCipher {
    // Include the methods countLetters and maxIndex that you wrote
    // in the previous lesson.
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
    
    // Write the void method simpleTests that has no parameters.
    public void simpleTests () {
        // read in a file as a String
        FileResource fr = new FileResource();
        String message = fr.asString();
        // create a CaesarCipher object with key 18
        CaesarCipher cc = new CaesarCipher(18);
        // encrypt the String read in using the CaesarCipher object
        String encryption = cc.encrypt(message);
        // print the encrypted String
        System.out.println("the encrypted String is " + encryption);
        // decrypt the encrypted String using the decrypt method.
        String decryption = cc.decrypt(encryption);
        System.out.println("the decrypted String is " + decryption);
        
        // add a call to breakCaesarCipher on the encrypted String to decrypt it
        // automatically by determining the key, and print the decrypted String.
        decryption = breakCaesarCipher(encryption);
        System.out.println("the decrypted with breakCaesarCipher String is "
            + decryption);
    }
    
    // Write the method breakCaesarCipher that has one String parameter named input.
    // This method should figure out which key was used to encrypt this message,
    // then create a CaesarCipher object with that key and decrypt the message.
    public String breakCaesarCipher (String input) {
        int[] freqs = countLetters(input);
        int maxDex = maxIndex (freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        CaesarCipher cc = new CaesarCipher(26 - dkey);
        return cc.encrypt(input);
    }
}
