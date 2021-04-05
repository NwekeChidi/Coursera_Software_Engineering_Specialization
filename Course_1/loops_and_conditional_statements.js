// This code is written using the IDE developed by https://www.dukelearntoprogram.com//course1/example/index.php


// Practicing For Loops


// To create a new image with all black pixels
var newImg = new SimpleImage( 200, 200 );
print( newImg );

// Writing a For Loop to change the pixels of the image to yellow
// yellow pixels have RGB values of 255, 255, 0
for ( var pixel of newImg.values() ){
    pixel.setGreen( 255 );
    pixel.setRed( 255 );
}
print( newImg );

// Writting a For Loop to change the pixels of the image to magenta
// magenta pixels have RGB values of 255, 0, 255
for ( var pixel of newImg.values() ){
    pixel.setGreen( 0 );
    pixel.setBlue( 255 );
}
print( newImg );


// Practicing Conditional Statements
// Example 1: Turn the Chapel red! 
// Write a code that enhances the red components of the image "chapel.png" to max.

// Getting Image
var chapelImg = new SimpleImage( "chapel.png" );
print( "Example 1: Turn the chapel red!")
print( "Initial Image: ", chapelImg );
for ( var pixel of chapelImg.values() ){
    pixel.setRed( 255 );
}
print( "Final Image: ", chapelImg );

// Example 2: Remove all the red!
// Write a code that removes all the red components of the "chapel.png" image.
// Resetting the Image
var chapelImg = new SimpleImage( "chapel.png" );
print();
print();
print( "Example 2: Remove all the red!");
print( "Initial Image: ", chapelImg );
for ( var pixel of chapelImg.values() ){
    pixel.setRed( 0 );
}
print( "Final Image: ", chapelImg );


// Example 3: Turn the Eggs less Red!
// Write a code that reduces  all the red components of the "eastereggs.jpg" image to 70.
// Getting the Image
var eggsImg = new SimpleImage( "eastereggs.jpg" );
print();
print();
print( "Example 3: Remove all the red!");
print( "Initial Image: ", eggsImg );
for ( var pixel of eggsImg.values() ){
    if ( pixel.getRed() >= 70 ){
        pixel.setRed( 70 ); 
    }
}
print( "Final Image: ", eggsImg );


// Example 4: Add Thick Black Line to Bottom of Owen!
// Write a code that adds a thick black line to the "astrachan.jpg" image.
// Getting Image
var owenImg = new SimpleImage( "astrachan.jpg" );
print();
print();
print( "Example 4: Add Thick Black Line to Bottom of Owen!");
print( "Initial Image: ", owenImg );
for ( var pixel of owenImg.values() ){
    var imgBtm = owenImg.getHeight() - 10;
    if ( pixel.getY() >= imgBtm ){
        pixel.setGreen( 0 );
        pixel.setBlue( 0 );
        pixel.setRed( 0 );
    }
}
print( "Final Image: ", owenImg );


// Example 5: Green Square in Top Left Corner!
// Write code that works on the image “chapel.png”, and replaces the top left corner with an all green square of size 50 by 50, resulting in the image.
// Getting the Image
var chapelImg = new SimpleImage( "chapel.png" );
print();
print();
print( "Example 5: Green Square in Top Left Corner!");
print( "Initial Image: ", chapelImg );
for ( var pixel of chapelImg.values() ){
    if ( pixel.getX() <= 50 && pixel.getY() <=50 ){
        pixel.setGreen( 255 );
        pixel.setRed( 0 );
        pixel.setBlue( 0 );
    }
}
print( "Final Image: ", chapelImg );


// Example 6: Rectangle of Any Color in Top Right Corner!
// Write a function named topRightCorner that puts a rectangle of a specified color and size in the top right corner of the image. The function topRightCorner has six parameters named cornerWidth, cornerHeight, someImage, red, green, and blue. This function replaces the top right corner of the image someImage with a rectangle of height cornerHeight and width cornerWidth, and color that has red, green and blue numeric values.
// For example, the call result = topRightCorner(30, 60, picture, 255, 255, 0)
// Getting the Images
var chapelImg = new SimpleImage( "chapel.png" );
var lionImg = new SimpleImage( "smalllion.jpg" );
print();
print();
print( "Example 6: Rectangle of Any Color in Top Right Corner!");
function topRightCorner( cornerWidth, cornerHeight, someImg, red, green, blue ){
    for ( var pixel of someImg.values() ){
        var height = someImg.getHeight();
        var width = someImg.getWidth();
        if ( pixel.getY() <= cornerHeight && pixel.getX() >= width-cornerWidth ){
            pixel.setGreen( green );
            pixel.setRed( red );
            pixel.setBlue( blue );
        }
    }
    return someImg
}
tChapel = topRightCorner(30, 60, chapelImg, 255, 255, 0);
tlion = topRightCorner(125, 20, lionImg, 255, 0, 0);
print( tChapel );
print( lionImg );



// Example 7: Changes in Red!
// Write the function named changeRed that draws a rectangle of width 256 showing all the changes of the color red, from left to right repeatedly, while blue and green are both set to 0.
print();
print();
print( "Example 7: Changes in Red!");
function changeRed( width, height ){
    var img = new SimpleImage( width, height );
    var red = 0
    for ( pixel of img.values() ){
        pixel.setRed( red )
        if ( red == width-1 ){
            red = 0;
        }
        else {
            red = red + 1
        }
    }
    return img
}
cRed = changeRed( 256, 200 );
print( cRed );


// Example 8: Changes in Colors!
// Write the function named changeRed that draws a rectangle of width 256 showing all the changes of the three colors, from left to right repeatedly, while blue and green are both set to 0.
print();
print();
print( "Example 8: Changes in Colors!");
function changeColors( width, height, red, green, blue ){
    var img = new SimpleImage( width, height );
    for ( pixel of img.values() ){
        pixel.setRed( red );
        pixel.setGreen( green );
        pixel.setBlue( blue );
        if ( red == width-1 ){
            red = 0;
        }
        else {
            red = red + 1
        }
    }
    return img
}
cColors = changeColors( 256, 200, 0, 200, 100 );
print( cColors );



// This an exercise from the Coursera Software Engineering Specialization
// link (for Loops): https://www.coursera.org/learn/duke-programming-web/supplement/XwS1Y/try-it-using-for-loops
// link (conditional statements): https://www.coursera.org/learn/duke-programming-web/supplement/N0JV6/rampup-programming-exercise-loops-and-conditionals