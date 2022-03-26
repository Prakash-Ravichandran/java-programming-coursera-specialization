
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
         public String findSimpleGene(String dna, int startCodon, int stopCodon){
        
    startCodon = dna.indexOf("atg" );
    System.out.println("The start value is" +startCodon);
	if (startCodon == -1) {
	    System.out.println("Checking");
	    startCodon = dna.indexOf("ATG");
	    System.out.println(startCodon);
	    stopCodon = dna.indexOf("TAA", startCodon + 3);  
	     System.out.println("Value of stop codon ="+stopCodon);   
            if(stopCodon == -1){
                return "null";
            }
        
            if ((stopCodon - startCodon) % 3 == 0 || (startCodon == 0)) {
                        System.out.println("Printing the mutliples of 3");
			return dna.substring(startCodon, stopCodon+3);
		}
		else {
			return "null";
		} 
	         
	       // return dna.substring(startCodon, stopCodon+3);
	       
		// return "null";
	}
	
     stopCodon = dna.indexOf("taa", startCodon + 3);
      if(stopCodon == -1){
          return "null";
        }
     if ((stopCodon - startCodon) % 3 == 0) {
                        System.out.println("Printing the mutliples of 3");
			return dna.substring(startCodon, stopCodon+3);
		}
		else {
		        System.out.println("The given string is not a multiple of 3");
			return "null";
		}   
    } 

    public void testSimpleGene(){
        String a = "ATGGGTMHJKTAAGTC"; // no ATG
        String b = "ataatgcqmlk"; // no TAA
        String c = "avbadfamctaa"; // no atg with taa
        String d = "avbatghtagbarvataa"; // substring is amultiple of 3
        String e = "avdatghtagvadftaa"; // substing is not a mutilple of 3
        String f = "HGJATGKLJHGJJTTAA";
        
        String result = findSimpleGene(a,0,0);
        System.out.println("The result of the string" + " " + a + " " + "is"  + " "  +result);
        
        String resultOne = findSimpleGene(b,0,0);
        System.out.println("The result of the string" + " " + b + " " + "is" + " "  +resultOne);
        
        String resultTwo = findSimpleGene(c,0,0);
        System.out.println("The result of the string" + " " + c + " " +"is" + " " +resultTwo);
        
        String resultThree = findSimpleGene(d,0,0);
        System.out.println("The result of the string" + " " + d + " " +"is" + " " +resultThree);
         
        String resultFour = findSimpleGene(e,0,0);
        System.out.println("The result of the string" + " " + e +  " " + "is" + " "  +resultFour);
        
        String resultFive = findSimpleGene(f,0,0);
        System.out.println("The result of the string" + " " + f +  " " + "is" + " "  +resultFive);
    
    
    }
}
