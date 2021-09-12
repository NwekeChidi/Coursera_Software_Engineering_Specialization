
/**
 * Write a description of PerimeterOfShape here.
 * This program is an exercise from the Coursera Software Engineering Fundamentals
 * Course 2, courtsey: AAL Egypt
 * @author (Chidimma Dominic Nweke) 
 * @version (22/06/2021)
 */

import edu.duke.*;

public class PerimeterOfShape {
    
    public double getPerimeter (Shape shape) {
        //Start with totalPerim = 0
        double totalPerim = 0;
        //Start with prevPt = the last point
        Point prevPt = shape.getLastPoint();
        //For each point currPt in the shape,
        for(Point currPt: shape.getPoints()) {
            //Find distance from prevPt to currPt, and name it currDist
            double currDist = prevPt.distance(currPt);
            //Update totalPerim to be totalPerim + currDist
            totalPerim = totalPerim + currDist;
            //Update prevPt to be currPt.
            prevPt = currPt;
        }
        //totalPerim is the answer
        return totalPerim;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }

    public static void main (String[] args) {
        PerimeterOfShape pr = new PerimeterOfShape();
        pr.testPerimeter();
    }
}



