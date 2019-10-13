
/**
 * Write a description of CaesarCipher here.
 * 
 * @author yamatokataoka
 * @version October 13th, 2019
 */
public class CaesarCipher {
    // Private fields for the alphabet and shiftedAlphabet
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    // Write a constructor CaesarCipher that has one int parameter key.
    // This method should initialize all the private fields of the class.
    public CaesarCipher (int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)
                        + alphabet.substring(0, key);
        mainKey = key;
    }
    
    // Write an encrypt method that has one String parameter named input.
    // This method returns a String that is the input encrypted using shiftedAlphabet.
    public String encrypt (String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int index = alphabet.indexOf(Character.toUpperCase(currentChar));
            if (index != -1) {
                if (Character.isUpperCase(currentChar)) {
                    encrypted.setCharAt(i, shiftedAlphabet.charAt(index));
                }
                else {
                    encrypted.setCharAt(i, shiftedAlphabet.toLowerCase()
                                            .charAt(index));
                }
            }
        }
        return encrypted.toString();
    }
    
    // Write a decrypt method that has one String parameter named input.
    // This method returns a String that is the encrypted String decrypted using
    // the key associated with this CaesarCipher object.
    public String decrypt (String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }
}
