// This code is written using the IDE developed by https://www.dukelearntoprogram.com//course1/example/index.php

// write your code here
// Part One:
// Write a JavaScript program that modifies an image by putting three vertical stripes on it - a red stripe on the left one third, a green stripe in the middle, and a blue stripe on the right one third.
// The red stripe is made by changing the red component of all the pixels in the left vertical third to 255, while leaving the green and blue components as their values in the original image. The green and blue stripes are made similarly, but instead of modifying the red component of each pixel in the correct part of the image you will modify the green or blue component. 

function rgbStripes( someImage ) {
    var width = someImage.getWidth();
    var qWidth = width / 3;
    for ( pixel of someImage.values() ){
        if ( pixel.getX() <= qWidth ){
            pixel.setRed( 255 );
        }
        if ( pixel.getX() <= qWidth*2 && pixel.getX() > qWidth ){
            pixel.setGreen( 255 );
        }
        if ( pixel.getX() <= width && pixel.getX() > qWidth*2 ){
            pixel.setBlue( 255 );
        }
    }
    return someImage
}

var imgHilt = new SimpleImage( "hilton.jpg" );
var imgEggs = new SimpleImage( "eastereggs.jpg")
var stripes1 = rgbStripes( imgHilt );
var stripes2 = rgbStripes( imgEggs );
print( "Part One: RGB Stripes on Image!")
print(stripes1);
print(stripes2);

// Part Two: Swap RedGreen!
// Write a JavaScript function named swapRedGreen with one parameter pixel (representing a single pixel). This function should swap the red and green values of the pixel. For example, if you have a pixel with red = 255, green = 100, blue = 150, after calling swapRedGreen on that pixel its new RGB values would be red = 100, green = 255, blue = 150. 
function swapRedGreen( someImage ){
    for ( pixel of someImage.values() ){
        red = pixel.getRed();
        green = pixel.getGreen();
        pixel.setRed( green );
        pixel.setGreen( red );
    }
    return someImage
}
print();
print();
print( "Part Two: SwapRedGreen!" );
var imghands = new SimpleImage( "smallhands.png" )
print( imghands );
redgreen1 = swapRedGreen( imghands );
print( redgreen1 );



// Part Three: Color Invert the Duke Devil
// Write code to change the Duke blue devil to be yellow.

function invertColor( someImage ){
    for ( pixel of someImage.values() ){
        if ( pixel.getRed() < 255 ){
            pixel.setBlue( 0 );
            pixel.setRed( 255 );
            pixel.setGreen( 255 );
        }
    }
    return someImage
}
print();
print();
print( "Part Three: Color Invert the Duke Devil!" );
var imgDuke = new SimpleImage( "duke_blue_devil.png" )
print( imgDuke );
dukeDevil = invertColor( imgDuke );
print( dukeDevil );


// This an exercise from the Coursera Software Engineering Specialization
// link ( Modifying Images ): https://www.coursera.org/learn/duke-programming-web/supplement/xApiL/programming-exercise-modifying-images