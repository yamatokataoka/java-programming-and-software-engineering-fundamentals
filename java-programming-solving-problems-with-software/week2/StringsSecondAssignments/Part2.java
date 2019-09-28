
/**
 * Write a description of Part2 here.
 * 
 * @author Yamato 
 * @version 2019/9/2
 */
public class Part2 {
    // Write the method named howMany that has two String parameters named 
    // stringa and stringb. This method returns an integer integer indicating 
    // how many times stringa appears in stringb, 
    // where each occurrence of stringa must not overlap 
    // with another occurrence of it.
    private int howMany(String stringa, String stringb) {
        int count = 0;
        int startIndex = 0;
        while (true) {
            int currentIndex = stringb.indexOf(stringa, startIndex);
            if (currentIndex == -1) {
                break;
            }
            count++;
            startIndex = stringb.indexOf(stringa, startIndex) 
                         + stringa.length();
        }
        return count;
    }
    
    // Write the void method testHowMany has no parameters.
    public void testHowMany() {
        // Add code in here to call howMany with several examples 
        // and print the results.
        String stringa = "GAA";
        System.out.println("stringa is " + stringa);
        String stringb = "ATGAACGAATTGAATC";
        System.out.println("stringb is " + stringb);
        int howMany = howMany(stringa, stringb);
        System.out.println(howMany + " time(s) occurs.");
        
        stringa = "AA";
        System.out.println("stringa is " + stringa);
        stringb = "ATAAAA";
        System.out.println("stringb is " + stringb);
        howMany = howMany(stringa, stringb);
        System.out.println(howMany + " time(s) occurs.");
    }
}
