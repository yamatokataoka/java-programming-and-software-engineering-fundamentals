
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author yamatokataoka
 * @version October 11th, 2019
 */

import edu.duke.*;

public class CaesarBreaker {
    // Complete the decryption method shown in the lesson by creating a
    // CaesarBreaker class with the methods countLetters, maxIndex, and
    // decrypt.
    public String decrypt (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex (freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }
    
    public int[] countLetters (String message) {
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
    
    public int maxIndex (int[] vals) {
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
    
    // Write the method halfOfString in the CaesarBreaker class that has
    // two parameters, a String parameter named message and an int parameter
    // named start. This method should return a new String that is every
    // other character from message starting with the start position.
    public String halfOfString (String message, int start) {
        String answer = "";
        for (int k = start; k< message.length() ; k+= 2) {
            answer = answer + message.charAt(k);    	
        }
        return answer;
    }
    
    // Write the method getKey in the CaesarBreaker class that has one
    // parameter, a String s.
    // This method should call countLetters to get an array of the letter
    // frequencies in String s and then use maxIndex to calculate the index
    // of the largest letter frequency, which is the location of the
    // encrypted letter ‘e’, which leads to the key, which is returned.
    public int getKey (String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex (freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        
        return dkey;
    }
    
    // Write the method decryptTwoKeys in the CaesarBreaker class that has
    // one parameter, a String parameter named encrypted that represents
    // a String that was encrypted with the two key algorithm.
    // This method attempts to determine the two keys used to encrypt the
    // message, prints the two keys, and then returns the decrypted String
    // with those two keys
    public String decryptTwoKeys (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        // Calculate a String of every other character starting with the
        // first character of the encrypted String by calling halfOfString.
        String firstHalfOfString = halfOfString(encrypted, 0);
        // Calculate a String of every other character starting with the
        // second character of the encrypted String.
        String secondHalfOfString = halfOfString(encrypted, 1);
        // Then calculate the key used to encrypt each half String.
        int firstDKey = getKey(firstHalfOfString);
        int secondDKey = getKey(secondHalfOfString);
        // print the two keys found.
        System.out.println("Found keys are " + firstDKey + ", " + secondDKey);
        // Calculate and return the decrypted String using the encryptTwoKeys
        // method from CaesarCipher class
        String decrypted = cc.encryptTwoKeys(encrypted, 26 - firstDKey
                                            , 26 - secondDKey);
        return decrypted;
    }
    
    // Write a testDecrypt method in the CaesarBreaker class that prints
    // the decrypted message, and make sure it works for encrypted messages
    // that were encrypted with one key.
    public void testDecrypt () {
        CaesarCipher cc = new CaesarCipher();
        String answer = "the legion";
        String encryption = cc.encrypt(answer, 23);
        String decryption = decrypt(encryption);
        System.out.println("decryption is " + decryption);
        // e is 2 times
        System.out.println("answer is     " + answer);
    }
    
    // test halfOfString method
    public void testHalfOfString () {
        String message = "Qbkm Zgis";
        int start = 0;
        String halfOfString = halfOfString(message, start);
        System.out.println("String is " + message);
        System.out.println("half of String is " + halfOfString);
        
        start = 1;
        halfOfString = halfOfString(message, start);
        System.out.println("String is " + message);
        System.out.println("half of String is " + halfOfString);
    }
    
    // test decryptTwoKeys
    public void testDecryptTwoKeys () {
        FileResource fr = new FileResource();
        String s = fr.asString();
        System.out.println("decryption is " + decryptTwoKeys(s));
        
        s = "Top ncmy qkff vi vguv vbg ycpx";
        System.out.println("decryption is " + decryptTwoKeys(s));
        
        s = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        System.out.println("decryption is " + decryptTwoKeys(s));
    }
}
