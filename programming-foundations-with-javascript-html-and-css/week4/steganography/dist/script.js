var canvasAElement = document.getElementById("canvas-a");
var canvasBElement = document.getElementById("canvas-b");
var startImageElement = document.getElementById("start-image");
var secretImageElement = document.getElementById("secret-image");

var startImage;
var secretImage;

function loadStartImage () {
  startImage = new SimpleImage(startImageElement);
  startImage.drawTo(canvasAElement);
}

function loadSecretImage () {
  secertImage = new SimpleImage(secretImageElement);
  secertImage.drawTo(canvasBElement);
}

function clearCanvas() {
  var canvasA = document.getElementById("canvas-a");
  var canvasB = document.getElementById("canvas-b");
  var contextA = canvasA.getContext("2d");
  var contextB = canvasB.getContext("2d");
  contextA.clearRect(0, 0, canvasA.width, canvasA.height);
  contextB.clearRect(0, 0, canvasB.width, canvasB.height);
}

function test () {
  startImage = chop2Hide(startImage);
  startImage.drawTo(canvasAElement);
}

function crop (image, width, height) {
  var output = new SimpleImage(width, height);
  for (var pixel of output.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    var originalPixel = image.getPixel(x,y);
    output.setPixel(x,y,originalPixel);
  }
  return output;
}

function clearbits (colorval) {
  var x = Math.floor(colorval/16) * 16;
  return x;
}

function chop2Hide (image) {
   for (var pixel of image.values()) {
     pixel.setRed(clearbits(pixel.getRed()));
     pixel.setGreen(clearbits(pixel.getGreen()));
     pixel.setBlue(clearbits(pixel.getBlue()));
     console.log(pixel.getRed() + " " + pixel.getGreen() + " " + pixel.getBlue());
  }
  return image;
}