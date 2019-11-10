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
        FileResource fr = new FileResource();
        // Use the asString method to read the entire contents of the file
        // into a String.
        String input = fr.asString();
        // Use the tryKeyLength method to find the key for the message
        // you read in
        int[] key = tryKeyLength(input, 5, 'e');
        // create a new VigenereCipher, passing in the key that tryKeyLength found
        VigenereCipher vc = new VigenereCipher(key);
        // use the VigenereCipher’s decrypt method to decrypt the encrypted message.
        System.out.println(vc.decrypt(input));
    }
    
}
