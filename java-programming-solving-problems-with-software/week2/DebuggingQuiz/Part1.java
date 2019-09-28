
/**
 * Write a description of ABC here.
 * 
 * @author Yamato Kataoka 
 * @version 20190905
 */
public class Part1 {
    // Write a method that finds each occurrence of “abc_” in a String input 
    // (where _ is a single character) and prints “bc_” for each such occurrence.
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1) {
                break;
            }
            int int1 = index + 1;
            int int2 = index + 4;
            if (index >= input.length() -3) {
                break;
            }
            System.out.println(int1 + ", " + int2);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+4);
        }
    }
    
    public void test() {
        // Test method findAbc()
        // findAbc("abcd");
        // Comment out the line findAbc("abcd") and 
        // add a new line in the test() method
        findAbc("abcdabc");
        findAbc("aaasdfafasfaaabc");
        findAbc("asfbcdabc");
    }
}
