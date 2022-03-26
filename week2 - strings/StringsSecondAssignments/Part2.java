
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
     public boolean  isEmpty(String s){
         
      System.out.println("The no of times the string repeated is =");   
      return s == null || s.length() == 0;
    }
    
    public  int howMany(String text, String str)
    {
        if (isEmpty(text) || isEmpty(str)) {
            return 0;
        }
 
        int index = 0, count = 0;
        while (true)
        {
            index = text.indexOf(str, index);
            if (index != -1)
            {
                count ++;
                index += str.length();
            }
            else {
                break;
            }
        }
 
        return count;
    }
 
    public  void testHowMany()
    {
        String text = "AABCCAAADCBBAADBBC";
        String str = "AA";
 
        int count = howMany(text, str);
        System.out.println(count);
    }
}
