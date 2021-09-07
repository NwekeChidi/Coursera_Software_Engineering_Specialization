package perimeter_quiz;

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

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        for (Point p: s.getPoints()) {
            count += 1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avgLength = getPerimeter(s) / (double) getNumPoints(s);
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point lastPt = s.getLastPoint();
        double largestSide = 0.0;
        
        for (Point currPt: s.getPoints()){
            double currDist = lastPt.distance(currPt);
            if (currDist > largestSide){
                largestSide = currDist;
            }
            lastPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point lastPt = s.getLastPoint();
        int lastX = lastPt.getX();
        double largestX = (double) lastX;
        
        for (Point currPt: s.getPoints()){
            int currX = currPt.getX();
            if (currX > largestX) {
                largestX = (double) currX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        FileResource largestFile = null;
        double largestPerim = 0.0;
        
        for (File f: dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double currPerim = getPerimeter(shape);
            if (currPerim > largestPerim) {
                largestPerim = currPerim;
            }
        }
        
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File temp = null;    
        // replace this code
        // replaced code: return temp.getName();
        for (File f: dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double currPerim = getPerimeter(shape);
            if (currPerim > largestPerim){
                largestPerim = currPerim;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        
        System.out.println("Perimeter = " + length);
        System.out.println("Number of points = " + numPoints);
        System.out.println("Average length = " + avgLength);
        System.out.println("Largest side = " + largestSide);
        System.out.println("Largest X = " + largestX);
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String file = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter = " + file);
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
