// Write a JavaScript function named swapRedGreen with one parameter pixel (representing a single pixel). This function should swap the red and green values of the pixel.
function swap (pixel) {
    var dukeRed = pixel.getRed();
    var dukeGreen = pixel.getGreen();
    var dukeBlue = pixel.getBlue();
    if (dukeRed == 0 && dukeGreen == 51 && dukeBlue == 227) {
        pixel.setRed(255);
        pixel.setGreen(255);
        pixel.setBlue(0);
    }
}

var img = new SimpleImage("duke_blue_devil.png");

for (var pixel of img.values()) {
    swap(pixel);
}
print(img);