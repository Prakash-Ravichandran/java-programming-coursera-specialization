
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        
    int start = dna.indexOf("atg");
    System.out.println("The start value is" +start);
	if (start == -1) {
		return "null";
	}
    int stop = dna.indexOf("taa", start + 3);
      System.out.println("The stop value is" +stop);
      if(stop == -1){
          return "null";
        }
     if ((stop - start) % 3 == 0) {
			return dna.substring(start, stop+3);
		}
		else {
			return "null";
		}   
    } 

    public void testSimpleGene(){
        String a = "Abcdefgh"; // no ATG
        String b = "ataatgcqmlk"; // no TAA
        String c = "avbadfamctaa"; // no atg with taa
        String d = "avbatghtagbarvataa"; // substring is amultiple of 3
        String e = "avdatghtagvadftaa"; // substing is not a mutilple of 3
        
        String result = findSimpleGene(a);
        System.out.println("The result of the string" + " " + a + " " + "is"  + " "  +result);
        
        String resultOne = findSimpleGene(b);
        System.out.println("The result of the string" + " " + b + " " + "is" + " "  +resultOne);
        
        String resultTwo = findSimpleGene(c);
        System.out.println("The result of the string" + " " + c + " " +"is" + " " +resultTwo);
        
        String resultThree = findSimpleGene(d);
        System.out.println("The result of the string" + " " + d + " " +"is" + " " +resultThree);
         
        String resultFour = findSimpleGene(e);
        System.out.println("The result of the string" + " " + e +  " " + "is" + " "  +resultFour);
    
    }
}
