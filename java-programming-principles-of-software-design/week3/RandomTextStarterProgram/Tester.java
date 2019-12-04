
/**
 * Write a description of Tester here.
 * 
 * @author yamatokataoka
 * @version December 5th, 2019
 */

import java.util.*;

public class Tester {
    public void testGetFollows() {
        MarkovOne markov = new MarkovOne();
        String trainingText = "this is a test yes this is a test.";
        markov.setTraining(trainingText);
        String key = "t";
        ArrayList<String> follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
    }
}
