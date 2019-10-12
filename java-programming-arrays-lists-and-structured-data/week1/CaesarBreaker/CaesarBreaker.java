
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author yamatokataoka
 * @version October 11th, 2019
 */
public class CaesarBreaker {
    // Complete the decryption method shown in the lesson by creating a
    // CaesarBreaker class with the methods countLetters, maxIndex, and
    // decrypt.
    public String decrypt (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex (freqs);
        int dkey = maxDex - 4;
        System.out.println(dkey);
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
            System.out.println(dkey);
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
    
    public int maxIndex (int[] vals) {
        int maxIndex = 0;
        for (int k=0; k < vals.length; k++) {
            // consider maxIndex so vals[maxIndex] rather than maxIndex
            if (vals[maxIndex] < vals[k]) {
                // And k rather than vals[k]
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    // Write a testDecrypt method in the CaesarBreaker class that prints
    // the decrypted message, and make sure it works for encrypted messages
    // that were encrypted with one key.
    public void testDecrypt () {
        CaesarCipher cc = new CaesarCipher();
        String answer = "the legion";
        String encryption = cc.encrypt(answer, 23);
        String decryption = decrypt(encryption);
        System.out.println("decryption is " + decryption);
        // e is 2 times
        System.out.println("answer is     " + answer);
    }
}
