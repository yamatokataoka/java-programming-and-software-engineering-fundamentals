
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
        System.out.println(trainingText.length());
        // test1
        String key = "t";
        ArrayList<String> follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
        // test2
        key = "e";
        follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
        // test3
        key = "es";
        follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
        // test4
        key = ".";
        follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
        // test5
        key = "t.";
        follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
    }
}
