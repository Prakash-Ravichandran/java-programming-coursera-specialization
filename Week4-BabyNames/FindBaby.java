import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.*;
import java.io.File;
/**
 * Write a description of FindBaby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindBaby {
       public void totalBirths(FileResource fr){
        
           int totalBirths = 0;
           int noOfBoys = 0;
           int noOfGirls = 0;
           
           for(CSVRecord record : fr.getCSVParser(false)){
               
               System.out.println(record);
               
              // System.out.println(record.get(2));
              // System.out.println(record.get(1));
              
              String gender = record.get(1);
              String male = "M";
               boolean boo = gender.equals(male);
              boolean bool = false;
              
              if( boo){
                 bool = true;
                }
                else { bool = false ;} 
               System.out.println(gender);
               System.out.println(bool);
                
                if( boo ){ noOfBoys++;}
                else { noOfGirls++; }
                
                totalBirths = noOfBoys + noOfGirls;
                System.out.println("The individual name are" +" " +record.get(0) );
            }
             System.out.println("Total boys are" +" "+noOfBoys);
             System.out.println("Total Girls are" +" "+noOfGirls);
        
        }
        
  
       public int getRank(Integer year, String name, String gender){
            
        int rank = 0;  
        
        FileResource fr = new FileResource();
       // int rank = 0;

        for(CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){ rank++; }
            if(rec.get(0).equals(name) && rec.get(1).equals(gender)){
                return rank;
            }
        }
        return -1;
    }
    
        public String getName(Integer year, Integer rank, String gender){
        FileResource fr = new FileResource();
        int nameRank = 0;

        for(CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){ nameRank++; }

            if(nameRank == rank && rec.get(1).equals(gender)){
                return rec.get(0);
            }
        }
        return "NO NAME";
        }
        
        public int yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int highestRank = 0;
        int highestYear = -1;

        for(File f: dr.selectedFiles()){
            int currYear = Integer.parseInt(f.getName().replaceAll("[^\\d]", ""));
            int currRank = getRank(currYear, name, gender);

            if(highestRank == 0 && currRank != -1){
                highestRank = currRank;
                highestYear = currYear;
            }
            if(currRank < highestRank && currRank != -1){
                highestRank = currRank;
                highestYear = currYear;
            }
        }
        return highestYear;
        }
        
        public double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int totalRank = 0, countedYears = 0;

        for(File f: dr.selectedFiles()){
            int currYear = Integer.parseInt(f.getName().replaceAll("[^\\d]", ""));
            int currRank = getRank(currYear, name, gender);

            if(currRank != -1){
                totalRank += currRank;
                countedYears++;
            }
        }
        double result = (double)totalRank/countedYears;
        if(result > 0){ return result; }
        return -1;
       }
       
        public  int getTotalBirthsRankedHigher(Integer year, String name, String gender){
        FileResource fr = new FileResource();
        int births = 0;
        int personsRank = getRank(year, name, gender);         //given persons rank in the given year

        for(CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                if(personsRank  > getRank(year, rec.get(0), gender)){
                    births += Integer.parseInt(rec.get(2));
                }
            }
        }
        return births;
    }
  
        
        public  void whatIsNameInYear(String name, Integer year, Integer newYear, String gender){
        int oldRank = getRank(year, name, gender);
        String newName = getName(newYear, oldRank, gender);

        System.out.println(name + "born in " + year + " would be " + newName + " if he/she was born in " + newYear);
        }

   
        public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
        }
        
        public void testRank(){
       //  int Rank = getHighestRank(2012,"Mason","M");
         int manRank = getRank(2012,"Ava","F");
       
         System.out.println("Therefore the Rank of the given string is" +" "+ manRank);
        }
        
        public void testGetName(){
        System.out.println(getName(2012, 2, "M"));    //Mason
        System.out.println(getName(2012, 5, "M"));    //NO NAME
        System.out.println(getName(2012, 5, "F"));    //Ava
        }
        
             //TEST method for whatIsNameInYear
        public void testWhatIsNameInYear(){
        whatIsNameInYear("Isabella", 2012, 2014, "F");      //Sophia
        whatIsNameInYear("Noah", 2013, 2012, "M");          //Jacob
        }
        
        
        
        public void testYearOfHighestRank(){
        System.out.println(yearOfHighestRank("Isabella", "F"));     //2012
        System.out.println(yearOfHighestRank("Lee", "M"));          //-1
        System.out.println(yearOfHighestRank("Emma", "F"));         //2014
        System.out.println(yearOfHighestRank("Emma", "M"));         //-1
        }
        
          //TEST method for getAverageRank
        public void testGetAverageRank(){
        System.out.println(getAverageRank("Sophia", "F"));      //1.66
        System.out.println(getAverageRank("Mason", "M"));       //3.0
        System.out.println(getAverageRank("Jacob", "M"));       //2.66
        System.out.println(getAverageRank("Lee", "M"));         //-1
        System.out.println(getAverageRank("Jacob", "F"));       //-1
        }
        
   

    //TEST method for getTotalBirthsRankedHigher
    public  void testGetTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher(2012, "Ethan", "M"));     //15
        System.out.println(getTotalBirthsRankedHigher(2012, "Emma", "F"));      //10
        System.out.println(getTotalBirthsRankedHigher(2012, "Isabella", "F"));  //19
        System.out.println(getTotalBirthsRankedHigher(2012, "Sophia", "F"));    //0
        System.out.println(getTotalBirthsRankedHigher(2012, "Lee", "M"));       //0
    

        
        
}

}
