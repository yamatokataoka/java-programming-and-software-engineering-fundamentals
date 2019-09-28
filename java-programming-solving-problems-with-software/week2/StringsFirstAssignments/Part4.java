
/**
 * Write a description of Part4 here.
 * 
 * @author Yamato kataoka 
 * @version 20190827
 */
import edu.duke.URLResource;

public class Part4 {
    public void findYoutube(String url) {
        // Use URLResource to read the file at 
        // http://www.dukelearntoprogram.com/course2/data/manylinks.html 
        // word by word
        String youtube = "youtube.com";
        String youtubeLink = "";
        int beginQuote;
        int endQuote;
        URLResource manylinks = new URLResource(url);
        int numYoutubelink = 0;
        // For each word, check to see if “youtube.com” is in it.
        for (String singleUrl : manylinks.words()) {
            String lowUrl = singleUrl.toLowerCase();
            int youtubeOccurrence = lowUrl.indexOf(youtube);
            // If it is, find the double quote to the left and right of 
            // the occurrence of “youtube.com” to identify the beginning 
            // and end of the URL.
            if (youtubeOccurrence != -1) {
                beginQuote = lowUrl.lastIndexOf("\"", youtubeOccurrence);
                endQuote = lowUrl.indexOf("\"", beginQuote + 1);
                youtubeLink = singleUrl.substring(beginQuote + 1, endQuote);
                System.out.println("Youtube lick is " + youtubeLink);
                numYoutubelink++;
            }
        }
        System.out.println("The number of links is " + numYoutubelink);
    }
}
