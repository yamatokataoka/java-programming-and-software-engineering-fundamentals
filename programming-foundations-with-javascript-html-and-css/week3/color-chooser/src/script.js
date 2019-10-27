function doColor () {
  var canvas = document.getElementById("canvas");
  var colorInput = document.getElementById("color");
  var color = colorInput.value;
  canvas.style.backgroundColor = color;
}