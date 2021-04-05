// This code is written using the IDE developed by https://www.dukelearntoprogram.com//course1/example/index.php


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


// This an exercise from the Coursera Software Engineering Specialization
// link: https://www.coursera.org/learn/duke-programming-web/supplement/XwS1Y/try-it-using-for-loops