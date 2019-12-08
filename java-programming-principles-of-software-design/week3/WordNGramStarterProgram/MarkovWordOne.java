
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author yamato
 * @version December 7th, 2019
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;

    public MarkovWordOne() {
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
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }

        return sb.toString().trim();
    }

    private ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        return follows;
    }

    private int indexOf(String[] words, String target, int start) {
        for (int k=start; k<words.length; k++) {
            if (words[k].equals(target)) {
                return k;
            }
        }

        return -1;
    }

    public void testIndexOf() {
        String text = "this is just a test yes this is a simple test";
        myText = text.split("\\s+");
        System.out.println(indexOf(myText, "this", 0));
        System.out.println(indexOf(myText, "this", 3));
        System.out.println(indexOf(myText, "frog", 0));
        System.out.println(indexOf(myText, "frog", 5));
        System.out.println(indexOf(myText, "simple", 2));
        System.out.println(indexOf(myText, "test", 5));
    }
}
