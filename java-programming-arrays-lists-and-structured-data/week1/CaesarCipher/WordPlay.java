
/**
 * Write a description of WordPlay here.
 * 
 * @author yamatokataoka
 * @version 20191003
 */
public class WordPlay {
    // Write a method isVowel that has one Char parameter named ch
    // This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u'
    // or the uppercase versions) and false otherwise.
    public boolean isVowel (char ch) {
        char upperCh = Character.toUpperCase(ch);
        String vowel = "AEIOU";
        int index = vowel.indexOf(upperCh);
        if (index != -1) {
            return true;
        }
        return false;
    }
    
    // test isVowel
    public void testIsVowel () {
        char ch = 'F';
        System.out.println("one char is " + ch);
        System.out.println("result is " + isVowel(ch));
        
        ch = 'f';
        System.out.println("one char is " + ch);
        System.out.println("result is " + isVowel(ch));
        
        ch = 'a';
        System.out.println("one char is " + ch);
        System.out.println("result is " + isVowel(ch));
        
        ch = ' ';
        System.out.println("one char is " + ch);
        System.out.println("result is " + isVowel(ch));
    }
}
