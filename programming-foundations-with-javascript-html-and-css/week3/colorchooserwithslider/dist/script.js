function doColor () {
  var canvas = document.getElementById("canvas");
  var colorInput = document.getElementById("color");
  var color = colorInput.value;
  canvas.style.backgroundColor = color;
}

function doSquare () {
  var canvas = document.getElementById("canvas");
  var slider = document.getElementById("slider");
  var context = canvas.getContext("2d");
  var value = slider.value;
  context.clearRect(0, 0, canvas.width, canvas.height);
  context.fillStyle = "yellow";
  context.fillRect(10, 10, value, value);
}