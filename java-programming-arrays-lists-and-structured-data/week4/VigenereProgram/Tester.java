
/**
 * Write a description of Tester here.
 * 
 * @author yamatokataoka
 * @version November 9th, 2019
 */

import edu.duke.*;

public class Tester {
    public void testCaesarCipher () {
        FileResource fr = new FileResource("VigenereTestData/titus-small.txt");
        String input = fr.asString();
        // creates a CaesarCipher object
        CaesarCipher cc = new CaesarCipher(5);
        // encrypt
        String encryption = cc.encrypt(input);
        System.out.println(encryption);
        // decrypt
        String decryption = cc.decrypt(encryption);
        System.out.println(decryption);
    }
}
