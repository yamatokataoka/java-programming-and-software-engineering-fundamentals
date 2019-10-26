var fileinput = document.getElementById("fileinput");
var canvas = document.getElementById("canvas");
var image;

function upload () {
  image = new SimpleImage(fileinput);
  image.drawTo(canvas);
}

function makeGray () {
  for (var pixel of image.values()) {
    var average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    console.log(average);
    pixel.setRed(average);
    pixel.setGreen(average);
    pixel.setBlue(average);
  }
  image.drawTo(canvas);
}