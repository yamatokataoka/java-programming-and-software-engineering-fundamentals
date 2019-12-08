
/**
 * Write a description of MarkovWordTwo here.
 * 
 * @author yamatokataoka
 * @version December 8th, 2019
 */

import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;

    public MarkovWordTwo() {
        myRandom = new Random();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index+1];
        sb.append(key1);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key1, key2);
            // System.out.println(key1 + " " + key2 + " " + follows);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }

        return sb.toString().trim();
    }

    private ArrayList<String> getFollows(String key1, String key2) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        // pos < myText.lenght - the number of keys
        while (pos<myText.length-2) {
            pos = indexOf(myText, key1, key2, pos);
            // pos < myText.lenght - the number of keys
            if (pos == -1 || pos >= myText.length-2) {
                break;
            }
            // pos + the number of keys
            follows.add(myText[pos+2]);
            pos++;
        }
        return follows;
    }

    private int indexOf(String[] words, String target1,
        String target2, int start) {

        for (int k=start; k<words.length; k++) {
            if (words[k].equals(target1) && words[k+1].equals(target2)) {
                return k;
            }
        }

        return -1;
    }

    public void testIndexOf() {
        String text = "this is just a test yes this is a simple test";
        myText = text.split("\\s+");
        System.out.println(indexOf(myText, "this", "is", 0));
        System.out.println(indexOf(myText, "this", "is", 3));
        System.out.println(indexOf(myText, "just", "a", 1));
        System.out.println(indexOf(myText, "simple", "test", 0));
    }
}
