import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    // This method returns a String consisting of every totalSlices-th character
    // from message, starting at the whichSlice-th character.
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sliceString = new StringBuilder();
        for (int k=whichSlice; k<message.length(); k += totalSlices) {
            sliceString.append(message.toCharArray()[k]);
        }
        return sliceString.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    
}
