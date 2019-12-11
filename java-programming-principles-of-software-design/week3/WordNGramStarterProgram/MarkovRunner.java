
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author yamatokataoka
 * @version December 7th, 2019
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size);
            printOut(st);
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource(); // practice quiz: 1 (confucius.txt)
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWordOne markovWord = new MarkovWordOne();
        // runModel(markovWord, st, 120, 175);
        runModel(markovWord, st, 30, 139); // practice quiz: 1
    }

    public void runMarkovTwo() {
        FileResource fr = new FileResource(); // practice quiz: 3 (confucius.txt)
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWordTwo markovWordTwo = new MarkovWordTwo();
        // runModel(markovWordTwo, st, 120, 549);
        runModel(markovWordTwo, st, 120, 832); // practice quiz: 3
    }

    public void testGetFollows() {
        String st = "this is just a test yes this is a simple test";
        MarkovWordOne markovWord = new MarkovWordOne();
        runModel(markovWord, st, 50); 
    }

    public void testGetFollowsForTwo() {
        String st = "this is just a test yes this is a simple test";
        MarkovWordTwo markovWordTwo = new MarkovWordTwo();
        runModel(markovWordTwo, st, 50);
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

}
