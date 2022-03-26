import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of ParseExportData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParseExportData {
    
   public void tester(){
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
    //   String ht = countryInfo(parser, "Germany");
    
      String ht = countryInfo(parser, "Nauru");
    //  listExportersTwoProducts(parser,"fish","nuts");  // for assignment
      
    //   int noOfCountries = numberOfExporters(parser,"gold");
    //   System.out.println("The nof countries exporting gold is" + " " +noOfCountries);
    
    //   int noOfCountries = numberOfExporters(parser,"sugar");  // for assignment
    //  System.out.println("The nof countries exporting gold is" + " " +noOfCountries);
      
     //  bigExporters(parser,"$999,999,999");
       
    }
    
    public String countryInfo(CSVParser parser, String country){
        
        for( CSVRecord record : parser){
            
            String allCountries = record.get("Country");
            if(allCountries.contains(country)){  
            String exportedProducts = record.get("Exports");
            String value = record.get("Value (dollars)"); 
            System.out.format("%-10s %-10s %-12s %-10s",country,":",exportedProducts,":",value);   
            }
            else {
                return "NOT FOUND";
            }
        }
        return "";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        
        for(CSVRecord record : parser){
            
            String exportedProducts = record.get("Exports");
            boolean bool1 = exportedProducts.contains(exportItem1);
            boolean bool2 = exportedProducts.contains(exportItem2);
            
            if( (bool1) && (bool2)){
                     String country = record.get("Country");
                     System.out.println("the value of the country is" +" "+ country);
            }  
        }
    } 
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int noOfCountries = 0;
        
        for(CSVRecord record : parser){
            String exportedProducts = record.get("Exports");
            boolean bool1 = exportedProducts.contains(exportItem);
            if( bool1){
                     String country = record.get("Country");
                     System.out.println("the value of the country is" +" "+ country);
                     noOfCountries++;
            }  
        }
        return noOfCountries;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        
        for(CSVRecord record : parser){
             String country = record.get("Country");
             if( country.length() < amount.length() ){
                String value = record.get("Value (dollars)");
                System.out.println(country +" "+ "$"+value);
             }
        }
    
    }  
}
