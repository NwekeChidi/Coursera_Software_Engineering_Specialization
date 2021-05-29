// The following lines of code was written using https://www.codepen.io


var fgImage=null;
var bgImage=null;

function upload() {
  var can1 = document.getElementById("can1");
  var can2 = document.getElementById("can2");
  var fgFile = document.getElementById("imageInput1");
  var bgFile = document.getElementById("imageInput");
  if ( fgImage == null ){
    fgImage = new SimpleImage(fgFile);
    fgImage.drawTo(can1);
  }
  if ( bgImage == null ) {
    bgImage = new SimpleImage(bgFile);
    bgImage.drawTo(can2);
  }
}


function greenScreen() {
  if ( fgImage == null || bgImage == null ){
    alert( "Images not loaded or loading incomplete!");
  }
  // Getting the Canvases by Id
  var can1 = document.getElementById("can1");
  var can2 = document.getElementById("can2");
  
  // Getting the context of the canvases
  var cont1 = can1.getContext("2d");
  var cont2 = can2.getContext("2d");
  
  // Implementing the Green Screen
  var output = new SimpleImage(fgImage.width, fgImage.height);
  for ( pixel of fgImage.values() ){
    var pX = pixel.getX();
    var pY = pixel.getY();
    if ( pixel.getGreen() > pixel.getBlue() + pixel.getRed() ){
      var nPxl = bgImage.getPixel( pX, pY );
      output.setPixel( pX, pY, nPxl );
    }
    else {
    output.setPixel( pX, pY, pixel);
    }
  }
  // to clear the canvases
  cont1.clearRect(0, 0, can1.width, can1.height);
  cont2.clearRect(0, 0, can2.width, can1.height);
  output.drawTo(can1)
}

function clearCanvas() {
  // Getting the Canvases by Id
  var can1 = document.getElementById("can1");
  var can2 = document.getElementById("can2");
  
  if ( fgImage == null && bgImage == null ){
    alert("Nothing to clear!");
  }
  
  // Getting the context of the canvases
  var cont1 = can1.getContext("2d");
  var cont2 = can2.getContext("2d");
  // to clear the canvases
  cont1.clearRect(0, 0, can1.width, can1.height);
  cont2.clearRect(0, 0, can2.width, can1.height);
}