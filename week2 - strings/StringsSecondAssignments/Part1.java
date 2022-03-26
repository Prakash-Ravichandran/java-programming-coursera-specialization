
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
      public int findStopCodon(String dna,int startIndex, String stopCodon){
           
          int stopIndex = dna.indexOf(stopCodon, startIndex+3);
          // System.out.println(stopIndex);
          if(stopIndex == -1){
              return dna.length();
            }
          else {
            System.out.println("The value of stopIndex before the loop is =" +stopIndex);
            while( stopIndex != -1){
                // System.out.println("The value of stopIndex in the loop is =" +stopIndex);
                //     System.out.println("The value of startIndex in the loop is =" +stopIndex);
                if( (stopIndex - stopIndex) % 3 == 0){ 
                //    System.out.println("The value of stopIndex in if section is =" +stopIndex);
                    break;}
                else {
                 stopIndex = dna.indexOf(stopCodon, startIndex + stopIndex);
                 //  System.out.println("The value of stopIndex in else section the loop is =" +stopIndex);
                }
            }
            
            }
          
          return stopIndex;
        } 
      public String findGene(String dna){
          int startIndex = dna.indexOf("ATG");
          if( startIndex == -1 ){ return "";}
          int taaIndex = findStopCodon(dna, startIndex, "TAA");
          int tagIndex = findStopCodon(dna, startIndex, "TAG");
          int tgaIndex = findStopCodon(dna, startIndex, "TGA");
          
          if((taaIndex > 0) && (tagIndex < 0 ) && (tgaIndex < 0) ){
            System.out.println(taaIndex);  
            return dna.substring(startIndex,taaIndex + 3);
            }
          if((taaIndex < 0) && (tagIndex > 0 ) && (tgaIndex < 0) ){
            System.out.println(taaIndex);  
            return dna.substring(startIndex,tagIndex + 3);
            }  
          if((taaIndex < 0) && (tagIndex < 0 ) && (tgaIndex > 0) ){
            System.out.println(taaIndex);  
            return dna.substring(startIndex,tgaIndex + 3);
            }  
          
          // for two stopCodons
          if( (taaIndex > 0) && (tagIndex > 0) || (tgaIndex < 0) ){
                if( taaIndex > tagIndex){
                   return dna.substring(startIndex, taaIndex + 3);
                }
                else {
                  return dna.substring(startIndex, tagIndex + 3);
                }
            
            }
          // for next two stop codons  
          if( (taaIndex < 0) || (tagIndex > 0) && (tgaIndex > 0)){
             if( tagIndex > tgaIndex){
                 return dna.substring(startIndex, tagIndex + 3);
                }
             else {
                return dna.substring(startIndex, tgaIndex + 3);
                }
            }  
           // for next two stop codons
          if( (taaIndex > 0) && (tgaIndex > 0) || (tagIndex < 0) ){
             if( taaIndex > tgaIndex){
                return dna.substring(startIndex, taaIndex + 3);
                }
             else {
                return dna.substring(startIndex, tgaIndex + 3);
                }   
            
            } 
        
          return "Hello";
        }  
        
      public void testFindGene(){
          
   //   String dnaOne = findGene("ASTAYUADFAMFADR"); // no valid stopcodons
   //   System.out.println("Therefore the gene found from string" +" " + "is" +" "+dnaOne);
      
                               //012345678912345
                               
  //   String dnaTwo = findGene("ATGCVGUHFOKNTAA"); // dna with one valid stopcodons
  //    System.out.println("Therefore the gene found from string" +" " + "is" +" "+dnaTwo);
       
   //  String dnaThree = findGene("ATGCVGUHFOKNTAAGTAHJKTAG"); // dna with two valid stopcodons
  //    System.out.println("Therefore the gene found from string" +" " + "is" +" "+dnaThree);
      
       
       
      String dnaFour = findGene("ATGCVGUHFOKNTAAGTAHJKTAGADFGTATGA"); // dna with three valid stopcodons
      System.out.println("Therefore the gene found from string" +" " + "is" +" "+dnaFour);
      
      
                               //012345678912345678912345678912345
  //    String dnaFive = findGene("ATGCVGUHFOKNTAGGTAHJKTGAADFGTATAA"); // dna with three valid stopcodons swapped
   //   System.out.println("Therefore the gene found from string" +" " + "is" +" "+dnaFive);
        }   
        
      public void testFindStopCodon(){
        
        int stopIndex = findStopCodon("ABATGYGHTKUTAA", 2, "TAA" );
        System.out.println("The value of stopIndex is = " + " " +stopIndex);
        
        }  
        
        
        
}
