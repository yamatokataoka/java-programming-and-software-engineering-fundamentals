
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author yamatokataoka
 * @version December 9th, 2019
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
        FileResource fr = new FileResource(); // practice quiz: 1, 2, 3, 4 (confucius.txt)
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        // MarkovWordOne markovWord = new MarkovWordOne(); 
        // runModel(markovWord, st, 200); 
        // MarkovWord markovWord = new MarkovWord(3); 
        // runModel(markovWord, st, 50, 643); 
        // runModel(markovWord, st, 50, 621); // practice quiz: 1

        // practice quiz: 2
        // MarkovWord markovWord = new MarkovWord(5);
        // runModel(markovWord, st, 50, 844);

        // practice quiz: 3
        // EfficientMarkovWord markovWord = new EfficientMarkovWord(3); 
        // runModel(markovWord, st, 50, 371);

        // practice quiz: 4
        EfficientMarkovWord markovWord = new EfficientMarkovWord(2); 
        runModel(markovWord, st, 50, 65);
    } 

    public void testHashMap() {
        // String st = "this is a test yes this is really a test";
        String st = "this is a test yes this is really a test yes a test this is wow";
        EfficientMarkovWord markovWord = new EfficientMarkovWord(2); 
        runModel(markovWord, st, 50, 42);
    }

    public void compareMethods() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');

        long nano_startTime = System.nanoTime();
        MarkovWord markovWord = new MarkovWord(2);
        runModel(markovWord, st, 100, 42);
        System.out.println((double)(System.nanoTime()-nano_startTime)/1000000000);

        nano_startTime = System.nanoTime();
        EfficientMarkovWord efficientMarkovWord = new EfficientMarkovWord(2); 
        runModel(efficientMarkovWord, st, 100, 42);
        System.out.println((double)(System.nanoTime()-nano_startTime)/1000000000);
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
