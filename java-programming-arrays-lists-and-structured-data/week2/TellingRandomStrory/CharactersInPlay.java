
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author yamatokataoka
 * @version October 19th, 2019
 */

import edu.duke.*;
import java.util.*;

// Create a class named CharactersInPlay
public class CharactersInPlay {
    // You will need to create two private ArrayLists.
    // One to store the the names of the characters you find and
    // one to store the corresponding counts for each character.
    private ArrayList<String> namesOfCharacters;
    private ArrayList<Integer> countsOfCharacter;
    
    // Write a constructor CharactersInPlay, and initialize the private variables.
    public CharactersInPlay () {
        namesOfCharacters = new ArrayList<String>();
        countsOfCharacter = new ArrayList<Integer>();
    }
    
    // Write a void method named update that has one String parameter named
    // person.
    private void update (String person) {
        int index = namesOfCharacters.indexOf(person);
        if (index == -1) {
            // adding the character’s name if it is not already there
            namesOfCharacters.add(person);
            countsOfCharacter.add(1);
        }
        else {
            // counting this line as one speaking part for this person
            int value = countsOfCharacter.get(index);
            countsOfCharacter.set(index, value+1);
        }
    }
    
    // Write a void method called findAllCharacters
    // call update to count it as an occurrence for this person.
    public void findAllCharacters () {
        // clear the appropriate instance variables before each new file
        namesOfCharacters.clear();
        countsOfCharacter.clear();
        
        // opens a file
        FileResource fr = new FileResource();
        
        // reads the file line-by-line.
        for (String line : fr.lines()) {
            // For each line, if there is a period on the line,
            // extract the possible name of the speaking part
            int indexOfPeriod = line.indexOf(".");
            if (indexOfPeriod != -1) {
                System.out.println(line);
                String name = line.substring(0, indexOfPeriod);
                update(name);
            }
        }
    }
    
    // Write a void method called tester that has no parameters.
    public void tester () {
        // call findAllCharacters
        findAllCharacters();
        
        // then for each main character, print out the main character,
        // followed by the number of speaking parts that character has.
        // A main character is one who has more speaking parts than most people.
        // You’ll have to estimate what that number should be.
        for (int k=0; k < namesOfCharacters.size(); k++) {
            System.out.println(namesOfCharacters.get(k) + " "
                            + countsOfCharacter.get(k));
        }
    }
}
