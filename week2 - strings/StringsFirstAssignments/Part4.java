import edu.duke.*;
import java.io.File;
import java.util.*;
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {

    public void testing(){
    
     URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
       for (String s : ur.words()) {
          // System.out.println(s);
           int index = s.indexOf("youtube.com");
           if(index > 0){
               System.out.println("index of the string" + " " + s + " is" + " " +index);
                 
               int indexQuotesLeft =s.indexOf("\"");
               
               System.out.println(indexQuotesLeft);
               
               int indexQuotesRight = s.indexOf("\"",s.indexOf("\"") + 1);
               
               System.out.println(indexQuotesRight);
               
               String link = s.substring(indexQuotesLeft, indexQuotesRight + 1); 
               
               System.out.println(link);
            }
         
       }
    }
}
