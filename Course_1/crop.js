// This code is written using the IDE developed by https://www.dukelearntoprogram.com//course1/example/index.php

// Steganography

// The Crop function
// In order to successfully hide one image in another, the two images must be of the same size, hence this crop function.
// This function looks at the two images and crops them
function crop( image, width, height ){
    var output = new SimpleImage( width, height );
    for ( var px of image.values() ){
        var x = px.getX();
        var y = px.getY();
        if ( x < width && y < height ){
            output.setPixel(x, y, px);
        }
    }
    return output
}

var img = new SimpleImage( 'usain.jpg' );
var height = 300;
var width = 400;
var orf = crop( img, width, height );
print(img);
print( "old image size: ", img.getHeight(), img.getWidth());
print(orf);
print( "cropped image size: ", orf.getHeight(), orf.getWidth());

