
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author yamatokataoka
 * @version December 7th, 2019
 */

import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel {
    private int n;
    HashMap<String, ArrayList<String>> followHash;

    public EfficientMarkovModel(int num) {
        myRandom = new Random();
        n = num;
        followHash = new HashMap<String, ArrayList<String>>();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
        buildMap();
        printHashMapInfo();
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-n);
        String key = myText.substring(index, index+n);
        sb.append(key);

        for(int k=0; k < numChars-key.length(); k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }

        return sb.toString();
    }

    public String toString() {
        return "MarkovModel of order " + n;
    }

    public void buildMap() {
        for (int i=n; i<=myText.length(); i++) {
            ArrayList<String> follows = new ArrayList<String>();
            String key = myText.substring(i-n, i);
            if (!followHash.containsKey(key)) {
                int pos = 0;
                while (pos < myText.length()-1) {
                    int index = myText.indexOf(key, pos);
                    if (index == -1 || index+key.length() >= myText.length()) {
                        break;
                    }
                    String follow = myText.substring(index+key.length(), index+key.length()+1);
                    follows.add(follow);
                    pos = index+1;
                }

                followHash.put(key, follows);
            }
        }
    }

    @Override
    protected ArrayList<String> getFollows(String key) {
        return followHash.get(key);
    }

    public void printHashMapInfo() {
        String largestKey = null;
        ArrayList<String> largestKeys = new ArrayList<String>();

        // System.out.println(followHash);
        System.out.println("keys " + followHash.size());
        for (String s : followHash.keySet()) {
            if (largestKey == null) {
                largestKey = s;
            }
            if (followHash.get(largestKey).size() < followHash.get(s).size()) {
                largestKey = s;
            }
        }
        System.out.println("largestSize " + followHash.get(largestKey).size());
        for (String s : followHash.keySet()) {
            if (followHash.get(largestKey).size() == followHash.get(s).size()) {
                largestKeys.add(s);
            }
        }
        System.out.println("largestKeys " + largestKeys);
    }
}
