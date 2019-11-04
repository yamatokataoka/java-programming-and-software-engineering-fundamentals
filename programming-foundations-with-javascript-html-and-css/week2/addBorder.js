// Write a function named setBlack that has one parameter pixel (representing a single pixel) and returns pixel with its red, green, and blue components changed so that the pixel’s color is black.
function setBlack (pixel) {
    pixel.setRed(0);
    pixel.setGreen(0);
    pixel.setBlue(0);
    return pixel;
}

// write another function named addBorder. This function will add a black border to an image
function addBorder (img) {
    for (var px of img.values()){
      var x = px.getX();
      var y = px.getY();
      if (x<= 10 || x>=img.getWidth()-10){
        setBlack(px);
      }
      if (y<= 10 || y>=img.getHeight()-10){
        setBlack(px);
      }
    }
}

var image = new SimpleImage("smallpanda.png");
addBorder(image);
print(image);