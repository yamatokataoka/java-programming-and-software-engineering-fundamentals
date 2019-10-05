
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
}
