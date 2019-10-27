
/**
 * Write a description of CaesarAutomaticDecryption here.
 * 
 * @author yamatokataoka
 * @version October 10th, 2019
 */

import edu.duke.*;

public class CaesarAutomaticDecryption {
    public String decrypt (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex (freqs);
        int dkey = maxDex - 4;
        System.out.println(dkey);
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
            System.out.println(dkey);
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
    
    public void testDecrypt () {
        String encryption = "qeb idbflk";
        String decryption = decrypt(encryption);
        System.out.println("decryption is " + decryption);
        // e is 2 times
        System.out.println("answer is     the legion");
    }
}
