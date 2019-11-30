
/**
 * Write a description of interface Filter here.
 * 
 * @author yamatokataoka
 * @version November 30th, 2019
 */
public interface Filter
{
    public  boolean satisfies(QuakeEntry qe);
    public String getName();
}
