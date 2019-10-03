
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
    
    // Write a method replaceVowels that has two parameters, a String named 
    // phrase and a Char named ch. 
    // This method should return a String that is the string phrase with 
    // all the vowels (uppercase or lowercase) replaced by ch
    public String replaceVowels (String phrase, char ch) {
        StringBuilder replacedPhrase = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char pheaseCh = replacedPhrase.charAt(i);
            if (isVowel(pheaseCh)) {
                replacedPhrase.setCharAt(i, ch); 
            }
        }
        return replacedPhrase.toString();
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
    
    // test replaceVowels
    public void testReplaceVowels () {
        String phrase = "Hello World";
        char ch = '#';
        System.out.println("input phrase is " + phrase);
        System.out.println("vowels replaced by " + ch);
        System.out.println("replaced phrase is " + replaceVowels(phrase, ch));
        
        phrase = "HELLO WORLD!";
        ch = '#';
        System.out.println("input phrase is " + phrase);
        System.out.println("vowels replaced by " + ch);
        System.out.println("replaced phrase is " + replaceVowels(phrase, ch));
    }
}
