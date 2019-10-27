
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author yamatokataoka
 * @version October 13th, 2019
 */
// Create the CaesarCipherTwo class
public class CaesarCipherTwoPatternTwo {
    // Include private fields for the alphabet, shiftedAlphabet1, and shiftedAlphabet2.
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    
    // Write a constructor CaesarCipherTwo that has two int parameters key1 and key2.
    // This method should initialize all the private fields.
    public CaesarCipherTwoPatternTwo (int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)
                        + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2)
                        + alphabet.substring(0, key2);
    }
    
    // Write an encrypt method that has one String parameter named input.
    // This method returns a String that is the input encrypted using the two shifted alphabets.
    public String encrypt (String input) {
        StringBuilder encryptedTwoKeys = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = encryptedTwoKeys.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                alphabet.toUpperCase();
                shiftedAlphabet1.toUpperCase();
                shiftedAlphabet2.toUpperCase();
            }
            else {
                alphabet.toLowerCase();
                shiftedAlphabet1.toLowerCase();
                shiftedAlphabet2.toLowerCase();
            }
            int index = alphabet.indexOf(currentChar);
            if (index != -1) {
                if (i % 2 == 0) {
                    encryptedTwoKeys.setCharAt(i, shiftedAlphabet1
                                            .charAt(index)); 
                }
                else {
                    encryptedTwoKeys.setCharAt(i, shiftedAlphabet2
                                            .charAt(index)); 
                }
            }
        }
        return encryptedTwoKeys.toString();
    }
}
