var canvasElement = document.getElementById("canvas");
var imageElement = document.getElementById("image");

var image;
var filteredImage;

function loadImage () {
  image = new SimpleImage(imageElement);
  image.drawTo(canvasElement);
}

function backtoOriginal () {
  image.drawTo(canvasElement);
}

function doGrayscale() {
  if (image == null || !image.complete()) {
    alert("No image loaded yet");
  }
  else {
    grayscale();
    filteredImage.drawTo(canvasElement);
  }
}

function doRed() {
  if (image == null || !image.complete()) {
    alert("No image loaded yet");
  }
  else {
    red();
    filteredImage.drawTo(canvasElement);
  }
}

function doFrance() {
  if (image == null || !image.complete()) {
    alert("No image loaded yet");
  }
  else {
    france();
    filteredImage.drawTo(canvasElement);
  }
}

function doBlur () {
  if (image == null || !image.complete()) {
    alert("No image loaded yet");
  }
  else {
    blur();
    filteredImage.drawTo(canvasElement);
  }
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
    filteredPixel = filteredImage.getPixel(x,y);
    
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
}

function blur () {
  filteredImage = new SimpleImage(image.getWidth(), image.getHeight());
  for (var pixel of image.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    if (0.5 < Math.random()) {
      filteredImage.setPixel(x,y,pixel);
    }
    else {
      do {
        randomX = x+getRandomInt(10);
        randomY = y+getRandomInt(10);
      } while (!isValid(randomX, image.getWidth()) || !isValid(randomY, image.getHeight()));
      console.log(!isValid(randomX, image.getWidth()) + ", " + randomX + ", " + randomY);
      randomPixel = image.getPixel(randomX, randomY);
      filteredImage.setPixel(x,y,randomPixel);
    }
  }
}

function getRandomInt(num) {
  if (0.5 < Math.random()) {
    return Math.floor(Math.random() * num);
  }
  else {
    return -Math.floor(Math.random() * num); 
  }
}

function isValid (num, max) {
  if (0 <= num && num < max) {
    return true;
  }
  else {
    return false;
  }
}