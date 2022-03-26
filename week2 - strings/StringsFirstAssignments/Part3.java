import java.io.*;
import java.util.*;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
 public boolean  isEmpty(String s){
      return s == null || s.length() == 0;
    }   
 public boolean twoOccurrences(String a, String b){
     
     boolean bool = false;
        if (isEmpty(a) || isEmpty(b)) {
            return false;
        }
        
        int index = 0, count = 0;
        while (true)
        {
            index = a.indexOf(b, index);
            if (index != -1)
            {
                count ++;
                index += b.length();
            }
            else {
                
                break;
            }
        }
        
        if (count > 0 && count > 2){
          return bool = true;
        }
        else  return bool;
           
    }
 public String lastPart(String a, String b){
    // System.out.println(a);
    int index = b.indexOf(a);
    System.out.println(index);
    if(index != -1)  return b.substring(a.length() + 1,b.length());
    else  return b;
    }  
    

 public void testing(){
       String text = "AABCCAAADCBBAADBBC";
       String str = "AA";
 
      // boolean bool  =twoOccurrences(text, str);
      // String lastPart = lastPart("an","banana");
       String lastPart2 = lastPart("an","mango");
       String lastPart3 = lastPart("zoo","forest");
       boolean bool = twoOccurrences("GAA", "ATGAACGAATTGAATC");
       System.out.println(lastPart2); 
       System.out.println(lastPart3);
       System.out.println("The string repeated is" +bool);
      // System.out.println("The statement occurences of a string" + " " + str + " " + "in" + " " +text + " " + "is " + "" +bool);
    }   
}
