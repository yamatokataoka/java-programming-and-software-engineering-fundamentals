import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    // Complete writing the method getNumPoints
    public int getNumPoints (Shape s) {
        // This method returns an integer that is the number of 
        // points in Shape s. Hint: You will need to 
        // iterate over all the points in the Shape S and count them.
        int count = 0;
        for (Point p : s.getPoints()) {
            count++;
        }
        return count;
    }
    
    // Complete writing the method getAverageLength
    public double getAverageLength(Shape s) {
        // This method returns a number of type double that is 
        // the calculated average of all the sides’ lengths 
        // in the Shape S.
        double average = getPerimeter(s) / getNumPoints(s);
        return average;
    }
    
    // Complete writing the method getLargestSide
    public double getLargestSide(Shape s) {
        // This method returns a number of type double that is 
        // the longest side in the Shape S.
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            // Find side from prevPt point to currPt 
            double currSide = prevPt.distance(currPt);
            if (largestSide < currSide) {
                largestSide = currSide;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestSide;
    }
    
    // Complete writing the method getLargestX
    public double getLargestX(Shape s) {
        // This method returns a number of type double that is the 
        // largest x value over all the points in the Shape s.
        double largestX = 0.0;
        for (Point currPt : s.getPoints()) {
            // Find side from prevPt point to currPt 
            double currX = currPt.getX();
            if (largestX < currX) {
                largestX = currX;
            }
        }
        return largestX;
    }
    
    // Complete writing the method getLargestPerimeterMultipleFiles
    public double getLargestPerimeterMultipleFiles() {
        // This method creates a DirectoryResource (so you can 
        // select multiple files) and then iterates over these files.
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // Then it creates a Shape from the FileResource and 
            // calculates the shapes perimeter.
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            // find the largest perimeter over all the shapes 
            // in the files you have selected.
            if (largestPerimeter < perimeter) {
                largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }
    
    // Finish writing the method getFileWithLargestPerimeter
    public String getFileWithLargestPerimeter() {
        // create its own Directory Resource
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        File temp = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // Then it creates a Shape from the FileResource and 
            // calculates the shapes perimeter.
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (largestPerimeter < perimeter) {
                largestPerimeter = perimeter;
                temp = f;
            }
        }
        // this new method returns the File name that has 
        // the largest such perimeter
        return temp.getName();
    }
    
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        // Add code in the method testPerimeter 
        // to call getNumPoints and to print the result.
        int numPoints = getNumPoints(s);
        System.out.println("The number of points = " + numPoints);
        
        // Add code in the method testPerimeter to call the method 
        // getAverageLength and to print out the result
        double average = getAverageLength(s);
        System.out.println("The average length = " + average);
        
        // Add code in the method testPerimeter to call the method 
        // getLargestSide and to print out the result.
        double largestSide = getLargestSide(s);
        System.out.println("The largest side = " + largestSide);
        
        // Add code in the method testPerimeter to call the method 
        // getLargestX and to print out the result. 
        double largestX = getLargestX(s);
        System.out.println("The largest X = " + largestX);
    }
    
    // Finish writing the void method testPerimeterMultipleFiles
    public void testPerimeterMultipleFiles() {
        // call getLargestPerimeterMultipleFiles and 
        // to print out the largest such perimeter.
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("The largest Perimeter in multiple file = " 
                            + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Add code to the method testFileWithLargestPerimeter to 
        // call getFileWithLargestPerimeter. For the File that is 
        // returned, print the name of that file.
        String fileName = getFileWithLargestPerimeter();
        System.out.println("The largest Perimeter's file = " 
                            + fileName);
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
        pr.testPerimeter();
    }
}
