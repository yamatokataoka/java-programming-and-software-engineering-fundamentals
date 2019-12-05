
/**
 * Write a description of MarkovOne here.
 * 
 * @author yamatokataoka
 * @version December 4th, 2019
 */

import java.util.*;

public class MarkovOne {
    private String myText;
    private Random myRandom;

    public MarkovOne() {
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length());
        String key = myText.substring(index, index+1);
        for(int k=0; k < numChars; k++){
            ArrayList<String> follows = getFollows(key);
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }

        return sb.toString();
    }

    public ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length()-1) {
            int index = myText.indexOf(key, pos);
            if (index == -1 || index+key.length() >= myText.length()) {
                break;
            }
            String follow = myText.substring(index+key.length(), index+key.length()+1);
            follows.add(follow);
            pos = index+key.length();
        }
        return follows;
    }
}
