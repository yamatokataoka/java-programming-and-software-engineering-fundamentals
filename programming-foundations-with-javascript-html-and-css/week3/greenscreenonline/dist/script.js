// Create global variables for the foreground image and background image
var foregroundImage = null;
var backgroundImage = null;
var canvasA = document.getElementById("canvas-a");
var canvasB = document.getElementById("canvas-b");

function loadForegroundImage() {
  var image = document.getElementById("foreground-input");
  foregroundImage = new SimpleImage(image);
  foregroundImage.drawTo(canvasA);
}

function loadBackgroundImage() {
  var image = document.getElementById("background-input");
  backgroundImage = new SimpleImage(image);
  backgroundImage.drawTo(canvasB); 
}

function doGreenScreen() {
  if (foregroundImage == null || ! foregroundImage.complete()) {
    alert("foreground not loaded");
    return;
  }
  if (backgroundImage == null || ! backgroundImage.complete()) {
    alert("background not loaded");
    return;
  }
  clearCanvas();
  var output = new SimpleImage(foregroundImage.getWidth(),
                              backgroundImage.getHeight());
  for (var pixel of foregroundImage.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    var greenThreshold = pixel.getRed() + pixel.getBlue();
    if (pixel.getGreen() > greenThreshold) {
      var backgroundPixel = backgroundImage.getPixel(x, y);
      output.setPixel(x, y, backgroundPixel);
    }
    else {
      output.setPixel(x, y, pixel); 
    }
  }
  output.drawTo(canvasA);
}

function clearCanvas() {
  var canvasA = document.getElementById("canvas-a");
  var canvasB = document.getElementById("canvas-b");
  var contextA = canvasA.getContext("2d");
  var contextB = canvasB.getContext("2d");
  contextA.clearRect(0, 0, canvasA.width, canvasA.height);
  contextB.clearRect(0, 0, canvasB.width, canvasB.height);
}