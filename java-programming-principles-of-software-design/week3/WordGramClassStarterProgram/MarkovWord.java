
/**
 * Write a description of MarkovWord here.
 * 
 * @author yamatokataoka
 * @version December 10th, 2019
 */

import java.util.*;

public class MarkovWord implements IMarkovModel{
    String[] myText;
    Random myRandom;
    int myOrder;

    public MarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram key = new WordGram(myText, index, myOrder);
        sb.append(key.toString());
        sb.append(" ");
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(key);
            System.out.println(key + " " + follows);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = key.shiftAdd(next);
        }

        return sb.toString().trim();
    }

    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos<myText.length-kGram.length()) {
            pos = indexOf(myText, kGram, pos);
            if (pos == -1 || pos >= myText.length-kGram.length()) {
                break;
            }
            follows.add(myText[pos+kGram.length()]);
            pos++;
        }
        return follows;
    }

    private int indexOf(String[] words, WordGram target, int start) {
        for (int k=start; k<=words.length-target.length(); k++) {
            WordGram wordsWG = new WordGram(words, k, target.length());
            if (wordsWG.equals(target)) {
                return k;
            }
        }

        return -1;
    }

    public void testIndexOf() {
        String text = "this is just a test yes this is a simple test";
        String test1S = "this is";
        String test2S = "frong";
        String test3S = "simple test";
        String[] test1A = test1S.split("\\s+");
        String[] test2A = test2S.split("\\s+");
        String[] test3A = test3S.split("\\s+");
        WordGram test1WG = new WordGram(test1A, 0, test1A.length);
        WordGram test11WG = new WordGram(test1A, 1, test1A.length-1);
        WordGram test2WG = new WordGram(test2A, 0, test2A.length);
        WordGram test3WG = new WordGram(test3A, 0, test3A.length);
        WordGram test31WG = new WordGram(test3A, 1, test3A.length-1);
        String[] test2 = new String [2];
        myText = text.split("\\s+");
        System.out.println(indexOf(myText, test1WG, 0));
        System.out.println(indexOf(myText, test11WG, 3));
        System.out.println(indexOf(myText, test2WG, 0));
        System.out.println(indexOf(myText, test2WG, 5));
        System.out.println(indexOf(myText, test3WG, 2));
        System.out.println(indexOf(myText, test31WG, 5));
    }
}
