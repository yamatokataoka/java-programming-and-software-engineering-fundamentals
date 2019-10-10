
/**
 * Write a description of CaesarAutomaticDecryption here.
 * 
 * @author yamatokataoka
 * @version October 10th, 2019
 */

public class CaesarAutomaticDecryption {
    public String decrypt (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int [] freqs = countLetters(encrypted);
        int maxDex = maxIndex (freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
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
}
