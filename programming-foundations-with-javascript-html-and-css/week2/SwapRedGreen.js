// Write a JavaScript function named swapRedGreen with one parameter pixel (representing a single pixel). This function should swap the red and green values of the pixel.
function swapRedGreen (pixel) {
    var Red = pixel.getRed();
    var Green = pixel.getGreen();
    pixel.setRed(Green);
    pixel.setGreen(Red);
}

var img = new SimpleImage("drewRobert.png");

for (var pixel of img.values()) {
    swapRedGreen(pixel);
}
print(img);