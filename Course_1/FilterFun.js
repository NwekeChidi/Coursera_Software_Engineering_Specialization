// The following lines of code was written using https://www.codepen.io

var image;
var rimage;
var canvas;

function upload() {
  canvas = document.getElementById("canvas");
  var imgFile = document.getElementById("tinput");
  image = new SimpleImage(imgFile);
  rimage = new SimpleImage(imgFile);
  image.drawTo(canvas)
}

// function to reset Image
function doReset(){
  for (pixel of image.values()){
    pX = pixel.getX();
    pY = pixel.getY();
    var npx = rimage.getPixel( pX,pY);
    image.setPixel( pX, pY, npx);
  }
  image.drawTo(canvas);
}

// function to make Image Red
function doRed() {
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  for ( pixel of image.values()){
    var avg = (pixel.getBlue()+pixel.getRed()+pixel.getGreen())/3;
    // Red
    if ( avg < 128 ){
      pixel.setRed(2*avg);
      pixel.setBlue(0);
      pixel.setGreen(0);
     }
     if (avg >= 128 ){
      pixel.setRed(255);
      pixel.setGreen(2*avg-255);
      pixel.setBlue(2*avg-255);
    }
  }
  image.drawTo(canvas);
}

// function to make Image Blue
function doBlue() {
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  for ( pixel of image.values()){
    var avg = (pixel.getBlue()+pixel.getRed()+pixel.getGreen())/3;
    if ( avg < 128 ){
      pixel.setBlue(2*avg);
      pixel.setRed(0);
      pixel.setGreen(0);
    }
    if (avg >= 128 ){
      pixel.setRed(2*avg-255);
      pixel.setGreen(2*avg-255);
      pixel.setBlue(255);
    }
  }
  image.drawTo(canvas);
}

// function to make Image Green
function doGreen() {
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  for ( pixel of image.values()){
    var avg = (pixel.getBlue()+pixel.getRed()+pixel.getGreen())/3;
    if ( avg < 128 ){
      pixel.setGreen(2*avg);
      pixel.setRed(0);
      pixel.setBlue(0);
    }
    if (avg >= 128 ){
      pixel.setRed(2*avg-255);
      pixel.setGreen(255);
      pixel.setBlue(2*avg-255);
    }
  }
  image.drawTo(canvas);
}

// Function to Make Rainbow
// //Vertical Rainbow
function doVRainbow() {
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  var width = image.width;
  var qWidth = width / 7;
  for ( pixel of image.values() ){
    var avg = (pixel.getBlue()+pixel.getRed()+pixel.getGreen())/3;
    // Red
    if ( pixel.getX() <= qWidth ){
      if ( avg < 128 ){
        pixel.setRed(2*avg);
        pixel.setBlue(0);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(255);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(2*avg-255);
      }
    }
    // Orange
    if ( pixel.getX() <= qWidth*2 && pixel.getX() > qWidth ){
      if ( avg < 128 ){
        pixel.setRed(2*avg);
        pixel.setGreen(0.8*avg);
        pixel.setBlue(0);
      }
      if (avg >= 128 ){
        pixel.setRed(255);
        pixel.setGreen(1.2*avg-51);
        pixel.setBlue(2*avg-255);
      }
    }
    //Yellow
    if ( pixel.getX() <= qWidth*3 && pixel.getX() > qWidth*2 ){
      if ( avg < 128 ){
        pixel.setRed(2*avg);
        pixel.setGreen(2*avg);
        pixel.setBlue(0);
      }
      if (avg >= 128 ){
        pixel.setRed(255);
        pixel.setGreen(255);
        pixel.setBlue(2*avg-255);
      }
    }
    // Green
    if ( pixel.getX() <= qWidth*4 && pixel.getX() > qWidth*3 ){
      if ( avg < 128 ){
        pixel.setGreen(2*avg);
        pixel.setRed(0);
        pixel.setBlue(0);
      }
      if (avg >= 128 ){
        pixel.setRed(2*avg-255);
        pixel.setGreen(255);
        pixel.setBlue(2*avg-255);
      }
    }
    // Blue
    if ( pixel.getX() <= qWidth*5 && pixel.getX() > qWidth*4 ){
      if ( avg < 128 ){
        pixel.setBlue(2*avg);
        pixel.setRed(0);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(2*avg-255);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(255);
      }
    }
    // Indigo
    if ( pixel.getX() <= qWidth*6 && pixel.getX() > qWidth*5 ){
      if ( avg < 128 ){
        pixel.setRed(0.8*avg);
        pixel.setBlue(2*avg);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(1.2*avg-255);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(255);
      }
    }
    // Violet
    if ( pixel.getX() <= width && pixel.getX() > qWidth*6 ){
      if ( avg < 128 ){
        pixel.setRed(1.6*avg);
        pixel.setBlue(1.6*avg);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(0.4*avg+153);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(0.4*avg+255);
      }
    }
  }
  image.drawTo(canvas)
}
// //Horizontal Rainbow
function doHRainbow() {
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  var height = image.height;
  var qHeight = height / 7;
  for ( pixel of image.values() ){
    var avg = (pixel.getBlue()+pixel.getRed()+pixel.getGreen())/3;
    // Red
    if ( pixel.getY() <= qHeight ){
      if ( avg < 128 ){
        pixel.setRed(2*avg);
        pixel.setBlue(0);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(255);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(2*avg-255);
      }
    }
    // Orange
    if ( pixel.getY() <= qHeight*2 && pixel.getY() > qHeight ){
      if ( avg < 128 ){
        pixel.setRed(2*avg);
        pixel.setGreen(0.8*avg);
        pixel.setBlue(0);
      }
      if (avg >= 128 ){
        pixel.setRed(255);
        pixel.setGreen(1.2*avg-51);
        pixel.setBlue(2*avg-255);
      }
    }
    //Yellow
    if ( pixel.getY() <= qHeight*3 && pixel.getY() > qHeight*2 ){
      if ( avg < 128 ){
        pixel.setRed(2*avg);
        pixel.setGreen(2*avg);
        pixel.setBlue(0);
      }
      if (avg >= 128 ){
        pixel.setRed(255);
        pixel.setGreen(255);
        pixel.setBlue(2*avg-255);
      }
    }
    // Green
    if ( pixel.getY() <= qHeight*4 && pixel.getY() > qHeight*3 ){
      if ( avg < 128 ){
        pixel.setGreen(2*avg);
        pixel.setRed(0);
        pixel.setBlue(0);
      }
      if (avg >= 128 ){
        pixel.setRed(2*avg-255);
        pixel.setGreen(255);
        pixel.setBlue(2*avg-255);
      }
    }
    // Blue
    if ( pixel.getY() <= qHeight*5 && pixel.getY() > qHeight*4 ){
      if ( avg < 128 ){
        pixel.setBlue(2*avg);
        pixel.setRed(0);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(2*avg-255);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(255);
      }
    }
    // Indigo
    if ( pixel.getY() <= qHeight*6 && pixel.getY() > qHeight*5 ){
      if ( avg < 128 ){
        pixel.setRed(0.8*avg);
        pixel.setBlue(2*avg);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(1.2*avg-255);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(255);
      }
    }
    // Violet
    if ( pixel.getY() <= height && pixel.getY() > qHeight*6 ){
      if ( avg < 128 ){
        pixel.setRed(1.6*avg);
        pixel.setBlue(1.6*avg);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(0.4*avg+153);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(0.4*avg+255);
      }
    }
  }
  image.drawTo(canvas)
}

// Function to Make Blur
// // Function to get shifted pixels
function getNpx(pixel, image){
  var randX = Math.floor((Math.random() * 10));
  var randY = Math.floor((Math.random() * 10));
  randX = randX*-1
  randY = randY*-1
  var nX = pixel.getX() + randX;
  var nY = pixel.getY() + randY;
  var nPx;
  if (nX>=0 && nX<image.width && nY>=0 && nY<image.height){
    nPx = image.getPixel(nX, nY);
  } else {
    nPx = image.getPixel(pixel.getX(), pixel.getY());
  }
  return nPx;
}
function doBlur(){
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  var output = new SimpleImage(image.width, image.height);
  for (pixel of output.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    var randFloat = Math.random();
    if (randFloat < 0.5){
      var nPx = getNpx(pixel, image);
      pixel.setRed(nPx.getRed());
      pixel.setGreen(nPx.getGreen())
      pixel.setBlue(nPx.getBlue())
      //output.setPixel(x, y, nPx);
    } else {
      output.setPixel(x, y, image.getPixel(x, y));
    }
  }
  output.drawTo(canvas);
}


// Function to Add Border
function setBlack( pixel ){
  pixel.setRed( 0 );
  pixel.setBlue( 0 );
  pixel.setGreen( 0 );
  return pixel
}

// Function to Add Border
function doBorder(){
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  var height = image.height;
  var width = image.width;
  var bThick = prompt("Input Border Thickness(must be a number!): ");
  for ( pixel of image.values() ){
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
  image.drawTo(canvas);
}

// Function to Add black spots
function doSpots(){
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  var output = new SimpleImage(image.width, image.height);
  for (pixel of output.values()) {
    var randFloat = Math.random();
    var x = pixel.getX();
    var y = pixel.getY();
    if (randFloat > 0.9){
      output.setPixel(x, y, pixel);
    }
    else {
      var npx = image.getPixel(x, y);
      output.setPixel(x, y, npx);
    }
  }
  output.drawTo(canvas);
}


// Function to Convert Image to Grayscale
function doGray() {
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  // converting Image to grayscale
  for ( pixel of image.values() ){
    var avg = ( pixel.getRed() + pixel.getGreen() + pixel.getBlue() )/3;
    pixel.setRed(avg);
    pixel.setGreen(avg);
    pixel.setBlue(avg);
  }
  image.drawTo(canvas);
}

// Function to Add RGB Stripes
function doStripes() {
  if ( image == null || !image.complete()) {
    alert("Please upload an image, or wait for image to load completely!")
  }
  var width = image.width;
  var qWidth = width / 3;
  for ( pixel of image.values() ){
    var avg = (pixel.getBlue()+pixel.getRed()+pixel.getGreen())/3;
    // Red
    if ( pixel.getX() <= qWidth ){
      if ( avg < 128 ){
        pixel.setRed(2*avg);
        pixel.setBlue(0);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(255);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(2*avg-255);
      }
    }
    // Green
    if ( pixel.getX() <= qWidth*2 && pixel.getX() > qWidth ){
      if ( avg < 128 ){
        pixel.setGreen(2*avg);
        pixel.setRed(0);
        pixel.setBlue(0);
      }
      if (avg >= 128 ){
        pixel.setRed(2*avg-255);
        pixel.setGreen(255);
        pixel.setBlue(2*avg-255);
      }
    }
    // Blue
    if ( pixel.getX() <= width && pixel.getX() > qWidth*2 ){
      if ( avg < 128 ){
        pixel.setBlue(2*avg);
        pixel.setRed(0);
        pixel.setGreen(0);
      }
      if (avg >= 128 ){
        pixel.setRed(2*avg-255);
        pixel.setGreen(2*avg-255);
        pixel.setBlue(255);
      }
    }
  }
  image.drawTo(canvas)
}

function clearCanvas(){
  var context = canvas.getContext("2d");
  context.clearRect(0,0,canvas.width,canvas.height);
  image=null;
}