
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunner {
    public void runMarkovZero() {
        FileResource fr = new FileResource(); // practice quiz: 2 (confucius.txt)
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovZero markov = new MarkovZero();
        //markov.setRandom(101);
        markov.setRandom(88); // practice quiz: 2
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }

    public void runMarkovOne() {
        // practice quiz: 5 (confucius.txt)
        // graded quiz: 5 (romeo.txt)
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        //markov.setRandom(42);
        // markov.setRandom(273); // practice quiz: 5
        markov.setRandom(365); // graded quiz: 5
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }

    public void runMarkovFour() {
        // practice quiz: 6 (confucius.txt)
        // graded quiz: 6 (romeo.txt)
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovFour markov = new MarkovFour();
        //markov.setRandom(25);
        // markov.setRandom(371); // practice quiz: 6
        markov.setRandom(715); // graded quiz: 6
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    
    public void runMarkovModel() {
        // practice quiz: 7 (confucius.txt)
        // graded quiz: 7 (romeo.txt)
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //MarkovModel markov = new MarkovModel(6);
        // MarkovModel markov = new MarkovModel(8); // practice quiz: 7
        MarkovModel markov = new MarkovModel(7); // graded quiz: 7
        //markov.setRandom(38);
        // markov.setRandom(365); // practice quiz: 7
        markov.setRandom(953); // graded quiz: 7
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
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