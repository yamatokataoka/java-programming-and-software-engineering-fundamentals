
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
    HashMap<WordGram, ArrayList<String>> followHash;

    public EfficientMarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
        followHash = new HashMap<WordGram, ArrayList<String>>();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
        buildMap();
        printHashMapInfo();
    }

    public void buildMap() {
        for (int k=0; k<=myText.length-myOrder; k++) {
            WordGram key = new WordGram(myText, k, myOrder);
            ArrayList<String> follows = new ArrayList<String>();

            if (followHash.containsKey(key)) {
                follows = followHash.get(key);
            }
            if (! (k>=myText.length-myOrder)) {
                follows.add(myText[k+myOrder]);
            }
            followHash.put(key, follows);
        }
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram key = new WordGram(myText, index, myOrder);
        sb.append(key.toString());
        sb.append(" ");
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(key);
            // System.out.println(key + " " + follows);
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
        if (followHash.containsKey(kGram)) {
            follows = followHash.get(kGram);
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

    public void printHashMapInfo() {
        WordGram largestKey = null;
        ArrayList<WordGram> largestKeys = new ArrayList<WordGram>();

        // System.out.println(followHash);
        System.out.println("keys " + followHash.size());
        for (WordGram wg : followHash.keySet()) {
            if (largestKey == null) {
                largestKey = wg;
            }
            if (followHash.get(largestKey).size() < followHash.get(wg).size()) {
                largestKey = wg;
            }
        }
        System.out.println("largestSize " + followHash.get(largestKey).size());
        for (WordGram wg : followHash.keySet()) {
            if (followHash.get(largestKey).size() == followHash.get(wg).size()) {
                largestKeys.add(wg);
            }
        }
        System.out.println("largestKeys " + largestKeys);
    }
}

