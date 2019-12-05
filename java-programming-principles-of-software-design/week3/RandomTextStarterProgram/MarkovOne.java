
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
        for(int k=0; k < numChars; k++){
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }

        return sb.toString();
    }
    
    public ArrayList<String> getFollows(String key) {
        ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        while (i<myText.length()-1) {
            int index = myText.indexOf(key, i);
            if (index != -1) {
                String follow = myText.substring(index+1, index+2);
                list.add(follow);
                i = index+1;
            }
        }
        return list;
    }
}
