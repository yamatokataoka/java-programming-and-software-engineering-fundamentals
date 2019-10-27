// write your code here
// Start with the image you want to change.
var img = new SimpleImage("duvall.jpg");

// Figure out the width of the image.
var w = img.getWidth();

// For each pixel in the image:
for (var pixel of img.values()) {
    // Get the x-coordinate for that pixel
    var x = pixel.getX();
    // If the pixel’s x-coordinate is less than one-third of the image’s width, set the pixel’s red value to 255.
    if (x < w/3) {
        pixel.setRed(255);
    }
    // If the pixel’s x-coordinate is between one-third and two-thirds of the image’s width, set the pixel’s green value to 255.
    else if (x >= w/3 && x < 2*w/3) {
        pixel.setGreen(255);
    }
    // If the pixel’s x-coordinate is more than two-thirds of the image’s width, set the pixel’s blue value to 255.
    else {
        pixel.setBlue(255);
    }
}
print(img);