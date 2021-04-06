// This code is written using the IDE developed by https://www.dukelearntoprogram.com//course1/example/index.php


// write your code here
// Part One: The Green Screen Algorithm
// Write the green screen algorithm you saw in the lecture video yourself. To make sure you really understand the code that was written in the video, you should write the code yourself without looking at the video unless you get stuck and need to refer back to it for a hint.

var bgImage = new SimpleImage( "drewRobert.png" );
var fgImage = new SimpleImage( "dinos.png" );
function greenScreen( fgImg, bgImg ){
    for ( pixel of bgImg.values() ){
        var pX = pixel.getX();
        var pY = pixel.getY();
        if ( pixel.getGreen() > pixel.getBlue() + pixel.getRed() ){
            var nPxl = fgImg.getPixel( pX, pY );
            bgImg.setPixel( pX, pY, nPxl );
        }
    }
    return bgImg
}
cScreen = greenScreen( fgImage, bgImage );
print( "Part One: Change Background" );
print( cScreen );


// Part Two: Find and Fix the Bug!
// Your friend is trying to write a program that draws a square 200 pixels by 200 pixels and that looks like this square with colors red (red value 255), green (green value 255), blue (blue value 255) and magenta (red value 255 and blue value 255). All other RGB values are set to 0.
print();
print();
print(" Part Two: Find And Fix The Bug!" );
// Original Code shown below: 
var img = new SimpleImage(200,200);
for (var px of img.values()){
  var x = px.getX();
  var y = px.getY();
  if (x < img.getWidth()/2){
    px.setRed(255);
  }
  if (y>img.getHeight()/2){
    px.setBlue(255);
  }
  else {
    px.setGreen(255);
  }
}
print( "Initial Image produced: ")
print (img);

// Fixed Code: 
var img = new SimpleImage(200,200);
for (var px of img.values()){
  var x = px.getX();
  var y = px.getY();
  if (x < img.getWidth()/2){
    px.setRed(255);
  }
   if (y>img.getHeight()/2){
     px.setBlue(255);
   }
  if ( x>= img.getHeight()/2 && y<= img.getWidth()/2){
    px.setGreen(255);
  }
}
print( "Correct Image After Bug is Fixed: ");
print (img);


// Part Three: Add Dark Border!
// Write a function named setBlack that has one parameter pixel (representing a single pixel) and returns pixel with its red, green, and blue components changed so that the pixel’s color is black.

// Now you will write another function named addBorder. This function will add a black border to an image

function setBlack( pixel ){
    pixel.setRed( 0 );
    pixel.setBlue( 0 );
    pixel.setGreen( 0 );
    return pixel
}

function addBorder( someImage, bThick ){
    var height = someImage.getHeight();
    var width = someImage.getWidth();
    for ( pixel of someImage.values() ){
        var x = pixel.getX();
        var y = pixel.getY();
        if ( x <= bThick ){
            pixel = setBlack(pixel)
        }
        if ( y <= bThick ){
            pixel = setBlack(pixel)
        }
        if ( y >= height - bThick ){
            pixel = setBlack(pixel)
        }
        if ( x >= width - bThick ){
            pixel = setBlack(pixel)
        }
    }
    return someImage
}

var imgPanda = new SimpleImage( "smallpanda.png" );
print();
print();
print( "Part Three: Add Dark Border!" )
print( "Initial Image: ");
print( imgPanda );
borBlack = addBorder( imgPanda, 10 );
print( "Image With Border: ")
print( borBlack );



// This an exercise from the Coursera Software Engineering Specialization
// link ( Modifying Images ):