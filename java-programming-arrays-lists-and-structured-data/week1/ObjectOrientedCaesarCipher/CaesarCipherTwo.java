
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author yamatokataoka
 * @version October 13th, 2019
 */

import edu.duke.*;

// Create the CaesarCipherTwo class
public class CaesarCipherTwo {
    // Include private fields for the alphabet, shiftedAlphabet1, and shiftedAlphabet2.
    private CaesarCipher cc1;
    private CaesarCipher cc2;
    
    // Write a constructor CaesarCipherTwo that has two int parameters key1 and key2.
    // This method should initialize all the private fields.
    public CaesarCipherTwo (int key1, int key2) {
        cc1 = new CaesarCipher(key1);
        cc2 = new CaesarCipher(key2);
    }
    
    // Write an encrypt method that has one String parameter named input.
    // This method returns a String that is the input encrypted using the two shifted alphabets.
    public String encrypt (String input) {
        StringBuilder encryptedTwoKeys = new StringBuilder(input);
        String encryptedKey1 = cc1.encrypt(input);
        String encryptedKey2 = cc2.encrypt(input);
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                char encryptedKey1Char = encryptedKey1.charAt(i);
                encryptedTwoKeys.setCharAt(i, encryptedKey1Char); 
            }
            else {
                char encryptedKey2Char = encryptedKey2.charAt(i);
                encryptedTwoKeys.setCharAt(i, encryptedKey2Char); 
            }
        }
        return encryptedTwoKeys.toString();
    }
    
    // Write a decrypt method that has one String parameter named input.
    // This method returns a String that is the encrypted String decrypted using
    // the key1 and key2 associated with this CaesarCipherTwo object. 
    public String decrypt (String input) {
        StringBuilder decryptedTwoKeys = new StringBuilder(input);
        String decryptedKey1 = cc1.decrypt(input);
        String decryptedKey2 = cc2.decrypt(input);
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                char decryptedKey1Char = decryptedKey1.charAt(i);
                decryptedTwoKeys.setCharAt(i, decryptedKey1Char); 
            }
            else {
                char decryptedKey2Char = decryptedKey2.charAt(i);
                decryptedTwoKeys.setCharAt(i, decryptedKey2Char); 
            }
        }
        return decryptedTwoKeys.toString();
    }
}
