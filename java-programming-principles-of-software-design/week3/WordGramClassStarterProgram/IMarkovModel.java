
/**
 * Write a description of interface IMarkovModel here.
 * 
 * @author yamatokataoka
 * @version December 9th, 2019
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
    
    public String getRandomText(int numChars);

}
