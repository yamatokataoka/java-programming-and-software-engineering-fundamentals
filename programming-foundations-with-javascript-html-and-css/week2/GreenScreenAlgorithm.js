var fgimage = new SimpleImage("drewRobert.png");
var bgimage = new SimpleImage("dinos.png");
var output = new SimpleImage(fgimage.getWidth(), fgimage.getHeight());

for (var pixel of fgimage.values()) {
    var x = pixel.getX();
    var y = pixel.getY()
    if (pixel.getGreen() > pixel.getRed() + pixel.getBlue()) {
        output.setPixel(x,y,bgimage.getPixel(x,y));
    }
    else {
        output.setPixel(x,y,fgimage.getPixel(x,y));
    }
}

print(output);