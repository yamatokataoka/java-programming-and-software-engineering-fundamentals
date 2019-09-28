
/**
 * Write a description of Part3 here.
 * 
 * @author Yamato Kataoka
 * @version 08/25/2019
 */
public class Part3 {
    // Write the method named twoOccurrences that has two String parameters 
    // named stringa and stringb. 
    // This method returns true if stringa appears at least twice in stringb, 
    // otherwise it returns false.
    private boolean twoOccurrences(String stringa, String stringb) {
        boolean result = false;
        int oneOccurrence = stringb.indexOf(stringa);
        if (oneOccurrence == -1) {
            return result = false;
        }
        int twoOccurrence = stringb.indexOf(stringa, oneOccurrence + stringa.length());
        if (twoOccurrence != -1) {
            return result = true;
        }
        return result;
    }
    
    // Write the method named lastPart that has two String parameters 
    // named stringa and stringb.
    private String lastPart(String stringa, String stringb) {
        String result = "";
        // This method finds the first occurrence of stringa in stringb
        int firstOccurrence = stringb.indexOf(stringa);
        if (firstOccurrence == -1) {
            return result = stringb;
        }
        result = stringb.substring(firstOccurrence + stringa.length());
        return result;
    }
    
    // Write the void method named testing that has no parameters
    public void testing() {
        // This method should call twoOccurrences on several pairs of strings
        // print the strings
        String stringa = "by";
        System.out.println("String A is " + stringa);
        String stringb = "A story by Abby Long";
        System.out.println("String B is " + stringb);
        // Print the result of calling twoOccurrences (true or false) 
        // for each pair
        boolean result = twoOccurrences(stringa, stringb);
        System.out.println("Result is " + result);
        
        stringa = "a";
        System.out.println("String A is " + stringa);
        stringb = "banana";
        System.out.println("String B is " + stringb);
        result = twoOccurrences(stringa, stringb);
        System.out.println("Result is " + result);
        
        stringa = "atg";
        System.out.println("String A is " + stringa);
        stringb = "ctgtatgta";
        System.out.println("String B is " + stringb);
        result = twoOccurrences(stringa, stringb);
        System.out.println("Result is " + result);
        
        stringa = "a";
        System.out.println("String A is " + stringa);
        stringb = "I am a party person";
        System.out.println("String B is " + stringb);
        result = twoOccurrences(stringa, stringb);
        System.out.println("Result is " + result);
        
        // Add code to the method testing to call the method lastPart 
        // with several pairs of strings
        stringa = "an";
        System.out.println("String A is " + stringa);
        stringb = "banana";
        System.out.println("String B is " + stringb);
        String result2 = lastPart(stringa, stringb);
        System.out.println("Result is " + result2);
        
        stringa = "zoo";
        System.out.println("String A is " + stringa);
        stringb = "forest";
        System.out.println("String B is " + stringb);
        result2 = lastPart(stringa, stringb);
        System.out.println("Result is " + result2);
    }
}
