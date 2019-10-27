var fileinput = document.getElementById("fileinput");
var canvas = document.getElementById("canvas");
var canvasGray = document.getElementById("canvasGray");
var image;
var grayimage;

function upload () {
  image = new SimpleImage(fileinput);
  grayimage = new SimpleImage(fileinput);
  image.drawTo(canvas);
}

function makeGray () {
  for (var pixel of grayimage.values()) {
    var average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    pixel.setRed(average);
    pixel.setGreen(average);
    pixel.setBlue(average);
  }
  grayimage.drawTo(canvasGray);
}