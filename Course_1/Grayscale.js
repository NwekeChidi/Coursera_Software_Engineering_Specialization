// The following lines of code was written using https://www.codepen.io

var image;
var imageGray;

function upload() {
  var can1 = document.getElementById("can1");
  var imgFile = document.getElementById("imageInput");
  image = new SimpleImage(imgFile);
  image.drawTo(can1);
}


function makeGray() {
  var can2 = document.getElementById("can2");
  var imgFile = document.getElementById("imageInput");
  imageGray = new SimpleImage(imgFile);
  // converting Image to grayscale
  for ( pixel of image.values() ){
    var avg = ( pixel.getRed() + pixel.getGreen() + pixel.getBlue() )/3;
    pixel.setRed(avg);
    pixel.setGreen(avg);
    pixel.setBlue(avg);
  }
  image.drawTo(can2)
}