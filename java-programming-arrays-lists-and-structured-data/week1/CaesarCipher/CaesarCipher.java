
/**
 * Write a description of CaesarCipher here.
 * 
 * @author yamatokataoka
 * @version October 5th, 2019
 */

import edu.duke.*;

public class CaesarCipher {
    // Write the method encrypt that has two parameters, a String named input
    // and an int named key. This method returns a String that has been encrypted 
    // using the Caesar Cipher algorithm explained in the videos. 
    // Assume that all the alphabetic characters are uppercase letters.
    // Modify the encrypt method to be able to handle both uppercase and
    // lowercase letters.
    public String encrypt (String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabets = alphabets.substring(key)
                                + alphabets.substring(0, key);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int index = alphabets.indexOf(Character.toUpperCase(currentChar));
            if (index != -1) {
                if (Character.isUpperCase(currentChar)) {
                    encrypted.setCharAt(i, shiftedAlphabets.charAt(index));
                }
                else {
                    encrypted.setCharAt(i, shiftedAlphabets.toLowerCase()
                                            .charAt(index));
                }
            }
        }
        return encrypted.toString();
    }
    
    // Write the method encryptTwoKeys that has three parameters, a String
    // named input, and two integers named key1 and key2. This method
    // returns a String that has been encrypted using the following algorithm.
    // Parameter key1 is used to encrypt every other character with the
    // Caesar Cipher algorithm, starting with the first character, and
    // key2 is used to encrypt every other character, starting with the 
    // second character.
    public String encryptTwoKeys (String input, int key1, int key2) {
        StringBuilder encryptedTwoKeys = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            String inputString = Character.toString(encryptedTwoKeys.charAt(i));
            if (i % 2 == 0) {
                char encryptedCKey1Char = encrypt(inputString, key1).charAt(0);
                encryptedTwoKeys.setCharAt(i, encryptedCKey1Char); 
            }
            else {
                char encryptedCKey2Char = encrypt(inputString, key2).charAt(0);
                encryptedTwoKeys.setCharAt(i, encryptedCKey2Char); 
            }
        }
        return encryptedTwoKeys.toString();
    }
    
    // Write the void method testCaesar that has no parameters. This method
    // should read a file and encrypt the complete file using the Caesar Cipher
    // algorithm, printing the encrypted message.
    public void testCaesar () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 23;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
    // test encrypt method
    public void testEncrypt () {
        // uppercase only
        String input = "FIRST LEGION ATTACK EAST FLANK!";
        int key = 23;
        System.out.println("input is " + input);
        System.out.println(key + " is shifted");
        System.out.println("encryption is " + encrypt(input, key));
        System.out.println("answer is     CFOPQ IBDFLK XQQXZH BXPQ CIXKH!");
        
        // lowercase and uppercase only
        input = "First Legion";
        key = 23;
        System.out.println("input is " + input);
        System.out.println(key + " is shifted");
        System.out.println("encryption is " + encrypt(input, key));
        System.out.println("answer is     Cfopq Ibdflk");
    }
    
    // test encryptTwoKeys method
    public void testEncryptTwoKeys () {
        String input = "First Legion";
        int key1 = 23;
        int key2 = 17;
        System.out.println("input is " + input);
        System.out.println("key1 is " + key1);
        System.out.println("key2 is " + key2);
        System.out.println("encryption is " + encryptTwoKeys(input, key1, key2));
        System.out.println("answer is     Czojq Ivdzle");
    }
}
