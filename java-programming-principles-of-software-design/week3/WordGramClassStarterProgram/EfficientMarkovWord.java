
/**
 * Write a description of EfficientMarkovWord here.
 * 
 * @author yamatokataoka
 * @version December 10th, 2019
 */

import java.util.*;

public class EfficientMarkovWord implements IMarkovModel{
    String[] myText;
    Random myRandom;
    int myOrder;

    public EfficientMarkovWord(int order) {
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
}

