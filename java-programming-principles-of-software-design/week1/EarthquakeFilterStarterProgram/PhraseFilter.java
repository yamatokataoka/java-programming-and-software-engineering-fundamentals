
/**
 * Write a description of PhraseFilter here.
 * 
 * @author yamatokataoka
 * @version November 30th, 2019
 */
public class PhraseFilter {
    private String where;
    private String phrase;

    public PhraseFilter(String w, String p) {
        where = w;
        phrase = p;
    }

    public boolean satisfies(QuakeEntry qe) {
        String title = qe.getInfo();
        int index = title.indexOf(phrase);
        return (where.equals("start") && index == 0)
                || (where.equals("end") && title.endsWith(phrase))
                || (where.equals("any") && index != -1); 
    }
}