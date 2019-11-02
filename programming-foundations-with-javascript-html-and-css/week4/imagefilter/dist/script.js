var canvasElement = document.getElementById("canvas");
var imageElement = document.getElementById("image");

var image;
var filteredImage;

function loadImage () {
  image = new SimpleImage(imageElement);
  image.drawTo(canvasElement);
}

function grayscale () {
  filteredImage = new SimpleImage(image.getWidth(), image.getHeight());
  for (var pixel of image.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    filteredPixel = filteredImage.getPixel(x,y)
    var average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    filteredPixel.setRed(average);
    filteredPixel.setGreen(average);
    filteredPixel.setBlue(average);
  }
  filteredImage.drawTo(canvasElement);
}

function red () {
   filteredImage = new SimpleImage(image.getWidth(), image.getHeight());
  for (var pixel of image.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    filteredPixel = filteredImage.getPixel(x,y)
    filteredPixel.setRed(255);
    filteredPixel.setGreen(pixel.getGreen());
    filteredPixel.setBlue(pixel.getBlue());
  }
  filteredImage.drawTo(canvasElement);
}

function france () {
   filteredImage = new SimpleImage(image.getWidth(), image.getHeight());
  var w = image.getWidth();
  for (var pixel of image.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    filteredPixel = filteredImage.getPixel(x,y)
    
    var red = pixel.getRed();
    var green = pixel.getGreen();
    var blue = pixel.getBlue();
    var maxNum = 255; 
    var minNum = 0;
    if (x < w/3) {
      filteredPixel.setRed(red);
      Math.max(minNum, Math.min(maxNum, filteredPixel.setGreen(green + 85)));
      Math.max(minNum, Math.min(maxNum, filteredPixel.setBlue(blue + 164)));
    }
    else if (x >= w/3 && x < 2*w/3) {
      Math.max(minNum, Math.min(maxNum, filteredPixel.setRed(red + 100)));
      Math.max(minNum, Math.min(maxNum, filteredPixel.setGreen(green + 100)));
      Math.max(minNum, Math.min(maxNum, filteredPixel.setBlue(blue + 100)));
    }
    else {
      Math.max(minNum, Math.min(maxNum, filteredPixel.setRed(red + 239)));
      Math.max(minNum, Math.min(maxNum, filteredPixel.setGreen(green + 65)));
      Math.max(minNum, Math.min(maxNum, filteredPixel.setBlue(blue + 53)));
    }
  }
  filteredImage.drawTo(canvasElement);
}

function backtoOriginal () {
  image.drawTo(canvasElement);
}