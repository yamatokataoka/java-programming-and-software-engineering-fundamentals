
/**
 * Write a description of interface IMarkovModel here.
 * 
 * @author yamatokataoka
 * @version Decmber 7th, 2019
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public String getRandomText(int numChars);
    
}
