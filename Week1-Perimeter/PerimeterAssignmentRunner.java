import edu.duke.*;
import java.io.File;
import java.util.*;
import java.util.ArrayList;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // sending shape point to getNumPoints method
      
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // System.out.println("The current distance is"+currDist);
            // getLargestSide(currDist);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int ptCount = 0;
         for(Point pt : s.getPoints()){
          ptCount++;
        }
       System.out.println("Total points in a shape = "+ptCount);
       return ptCount;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perimeter = getPerimeter(s);
        int sidesCount = getNumPoints(s);
        double avLength = perimeter/sidesCount;
        System.out.println("The average length of all sides =" +""+avLength);
        return avLength;
    }

    public double getLargestSide(Shape s) {
        //double[] lnArr = new double[];
        // ArrayList<Integer>  = new ArrayList<>();
        double largestSide=0.0;
        Point prevPt = s.getLastPoint();
        // sending shape point to getNumPoints method
        LinkedList<Double> a = new LinkedList<>();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
             a.push(currDist);   
        }
        System.out.println("printing the lengths of shape" + "" + a);
        //finding largest side 
        double max = a.get(0);
        double n = a.size();
        for (int i = 1; i < n; i++) {
            if (a.get(i) > max) {
                max = a.get(i);
            }
        }
        largestSide = max;
        System.out.println("The largest side of an array is =" + "" +largestSide);
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
         LinkedList<Integer> arrX = new LinkedList<>();
         Point prevPt = s.getLastPoint();
        // System.out.println(pts); 
         for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
         double currDist = prevPt.distance(currPt);
         int y = currPt.getX();
         arrX.push(y);
         System.out.println(currPt);
        }
        System.out.println("The X Coordinates of the shapes are " + " " +arrX);
        // finding max of X-coordinates
        double max = arrX.get(0);
        double n = arrX.size();
        for (int i = 1; i < n; i++) {
            if (arrX.get(i) > max) {
                max = arrX.get(i);
            }
        }
        double largestX = max;
        System.out.println("The largest X co-ordinate of a shape =" + " " +largestX);
        return largestX;
    }

   /* public double getLargestPerimeterMultipleFiles() {
        // Put code here
        LinkedList<Double> arrPerimeter = new LinkedList<>();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
           // System.out.println(f.getName());
            
            getFileWithLargestPerimeter(f);
            Shape s = new Shape(fr);
            //  System.out.println(s.getClass());
            double perimeter=getPerimeter(s);
            System.out.println("The Individual perimeter values are"+" "+perimeter);
            arrPerimeter.push(perimeter);
        }
        System.out.println(arrPerimeter);
        
        double max = arrPerimeter.get(0);
        double n = arrPerimeter.size();
        for (int i = 1; i < n; i++) {
            if (arrPerimeter.get(i) > max) {
                max = arrPerimeter.get(i);
            }
        }
        double largestPerimeter = max;
        System.out.println("The Largest Perimieter is =" + " " +largestPerimeter);
        return largestPerimeter;
    } */
    
   public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
         HashMap<String, Double> ht1 = new HashMap<>();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
           // System.out.println(f.getName())
            Shape s = new Shape(fr);
            //  System.out.println(s.getClass());
            double perimeter=getPerimeter(s);
             
             ht1.put(f.getName(),perimeter);
             System.out.println("The hastable are" +ht1);
            
             System.out.println("The Individual perimeter values are"+" "+perimeter);
        }
         System.out.println("The values of ht1 are" +ht1.values());
         
         // calculating maximum of all perimeter
          double max = 0.0;
          for (Map.Entry<String, Double> e : ht1.entrySet()) {
              double temp = e.getValue();
              if(temp > max){
                  max = temp;
                }
                else {
                    max = e.getValue();
                }
           
            System.out.println("FileName: " + e.getKey()+ " Perimeter: " + e.getValue());    
        }
        System.out.println("The Largest Perimeter is =" + " "+max);
        return max;
    } 

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        HashMap<String, Double> ht1 = new HashMap<>();
         for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter=getPerimeter(s);
            ht1.put(f.getName(),perimeter);
            System.out.println("The hastable are" +ht1);
            System.out.println("The Individual perimeter values are"+" "+perimeter);
        }
        
       //File temp = null;  
       // replace this code
       // System.out.println(temp.getName());
       //return temp.getName();
       // calculating maximum of all perimeter
        double max = 0.0;
        String maxFile = "";
        for (Map.Entry<String, Double> e : ht1.entrySet()) {
              double temp = e.getValue();
              if(temp > max){
                  max = temp;
                  maxFile = e.getKey();
                }
                else {
                    max = e.getValue();
                    maxFile = e.getKey();
                }     
        }
        System.out.println("The max-perimeter file is =" + " " +maxFile);
        return maxFile;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        // sending shape to getNumPoints Method
        getNumPoints(s); 
        getAverageLength(s);
        getLargestSide(s);
        getLargestX(s);
        System.out.println("perimeter = " + length);
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        getLargestPerimeterMultipleFiles();
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        getFileWithLargestPerimeter();
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        //pr.testFileWithLargestPerimeter();
    }
}
