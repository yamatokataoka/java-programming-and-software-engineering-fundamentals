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
  secretImage = new SimpleImage(secretImageElement);
  secretImage.drawTo(canvasBElement);
}

function clearCanvas() {
  var canvasA = document.getElementById("canvas-a");
  var canvasB = document.getElementById("canvas-b");
  var contextA = canvasA.getContext("2d");
  var contextB = canvasB.getContext("2d");
  contextA.clearRect(0, 0, canvasA.width, canvasA.height);
  contextB.clearRect(0, 0, canvasB.width, canvasB.height);
}

function stego () {
  var cropWidth = startImage.getWidth();
  if (secretImage.getWidth() < cropWidth) {
    cropWidth = secretImage.getWidth();
  }
  var cropHeight = startImage.getHeight();
  if (secretImage.getHeight() < cropHeight) {
    cropHeight = secretImage.getHeight();
  }
  startImage = crop(startImage, cropWidth, cropHeight);
  secretImage = crop(secretImage, cropWidth, cropHeight);
  startImage = combine(startImage, secretImage);
  clearCanvas();
  startImage.drawTo(canvasAElement);
}

function crop (image, width, height) {
  var output = new SimpleImage(width, height);
  for (var pixel of output.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    if (x < width && y < height){
      var originalPixel = image.getPixel(x,y);
      output.setPixel(x,y,originalPixel);
    }
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

function shift (image) {
   for (var pixel of image.values()) {
     pixel.setRed(pixel.getRed() / 16);
     pixel.setGreen(pixel.getGreen() / 16);
     pixel.setBlue(pixel.getBlue() / 16);
     console.log(pixel.getRed() + " " + pixel.getGreen() + " " + pixel.getBlue());
  }
  return image;
}

function combine (startImage, secretImage) {
  var output = new SimpleImage(startImage.getWidth(), startImage.getHeight());
  for (var pixel of startImage.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    var outputPixel = output.getPixel(x, y);
    var secretPixel = secretImage.getPixel(x, y);
    outputPixel.setRed(pixel.getRed() + secretPixel.getRed());
    outputPixel.setGreen(pixel.getGreen() + secretPixel.getGreen());
    outputPixel.setBlue(pixel.getBlue() + secretPixel.getBlue());
    console.log(outputPixel.getRed() + " " + outputPixel.getGreen() + " " + outputPixel.getBlue());
  }
  return output;
}