
/**
 * Write a description of Part2 here.
 * 
 * @author Yamato Kataoka 
 * @version 20190905
 */
public class Part2 {
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1) {
                break;
            }
            
            if (index >= input.length() -3) {
                break;
            }
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            
            System.out.println("index " + index);
            index = input.indexOf("abc", index+3);
            System.out.println("index after updating " + index);
        }
    }
    
    public void test() {
        // Test method findAbc()
        // findAbc("abcd");
        // Comment out the line findAbc("abcd") and 
        // add a new line in the test() method
        // findAbc("abcdabc");
        // findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
        findAbc("abcabcabcabca");
    }
}
