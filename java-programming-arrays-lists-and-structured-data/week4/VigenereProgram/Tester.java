
/**
 * Write a description of Tester here.
 * 
 * @author yamatokataoka
 * @version November 9th, 2019
 */

import edu.duke.*;
import java.util.*;

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
    
    public void testCaesarCracker () {
        FileResource fr = new FileResource("VigenereTestData/titus-small_key5.txt");
        String input = fr.asString();
        // making a new CaesarCracker object
        CaesarCracker cc = new CaesarCracker();
        // decrypting the file titus-small_key5.txt
        String decryption = cc.decrypt(input);
        System.out.println(decryption);
        // and the file oslusiadas_key17.txt, noting that the most common
        // character in Portuguese is ‘a’.
        fr = new FileResource("VigenereTestData/oslusiadas_key17.txt");
        input = fr.asString();
        cc = new CaesarCracker('a');
        decryption = cc.decrypt(input);
        System.out.println(decryption);
    }
    
    public void testVigenereCipher () {
        FileResource fr = new FileResource("VigenereTestData/titus-small.txt");
        String input = fr.asString();
        // creating a VigenereCipher object with the key “rome”
        int[] rome = {17, 14, 12, 4};
        VigenereCipher vc = new VigenereCipher(rome);
        // encrypting
        String encryption = vc.encrypt(input);
        System.out.println(encryption);
        // decrypting
        String decryption = vc.decrypt(encryption);
        System.out.println(decryption);
    }
    
    public void testSliceString () {
        VigenereBreaker vb = new VigenereBreaker();
        String sliceString = vb.sliceString("abcdefghijklm", 0, 3);
        System.out.println(sliceString);
        sliceString = vb.sliceString("abcdefghijklm", 1, 3);
        System.out.println(sliceString);
        sliceString = vb.sliceString("abcdefghijklm", 3, 5);
        System.out.println(sliceString);
    }
    
    public void testTryKeyLength () {
        // FileResource fr = new FileResource("VigenereTestData/athens_keyflute.txt");
        // String input = fr.asString();
        // VigenereBreaker vb = new VigenereBreaker();
        // System.out.println(Arrays.toString(vb.tryKeyLength(input, 5, 'e')));
        // Q1: What is the key used to encrypt the file secretmessage1.txt?
        FileResource fr = new FileResource("messages/secretmessage1.txt");
        String input = fr.asString();
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println(Arrays.toString(vb.tryKeyLength(input, 4, 'e')));
    }
    
    public void testReadDictionary () {
        FileResource fr = new FileResource();
        VigenereBreaker vb = new VigenereBreaker();
        HashSet<String> set = vb.readDictionary(fr);
        System.out.println(set.size());
    }
    
    public void testCountWords () {
        String message = "word excellent HAPPY pspsps";
        FileResource fr = new FileResource("dictionaries/English");
        VigenereBreaker vb = new VigenereBreaker();
        HashSet<String> set = vb.readDictionary(fr);
        System.out.println(vb.countWords(message, set));
    }
    
    public void testBreakForLanguage () {
        FileResource frDictionary = new FileResource("dictionaries/English");
        FileResource frEncrypted = new FileResource("VigenereTestData/athens_keyflute.txt");
        String encrypted = frEncrypted.asString();
        VigenereBreaker vb = new VigenereBreaker();
        HashSet<String> dictionary = vb.readDictionary(frDictionary);
        System.out.println(vb.breakForLanguage(encrypted, dictionary));
    }
    
    public void testMostCommonCharIn () {
        VigenereBreaker vb = new VigenereBreaker();
        FileResource frDictionary = new FileResource("dictionaries/English");
        HashSet<String> dictionary = vb.readDictionary(frDictionary);
        char mostCommonChar = vb.mostCommonCharIn(dictionary);
        System.out.println(mostCommonChar);
    }
}
