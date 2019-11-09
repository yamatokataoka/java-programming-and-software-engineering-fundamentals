var canvasAElement = document.getElementById("canvas-a");
var canvasBElement = document.getElementById("canvas-b");
var startImageElement = document.getElementById("start-image");
var secretImageElement = document.getElementById("secret-image");

var startImage;
var secretImage;

function loadStartImage () {
  startImage = new SimpleImage(startImageElement);
  startImage.drawTo(canvasAElement);
}

function loadSecretImage () {
  secertImage = new SimpleImage(secretImageElement);
  secertImage.drawTo(canvasBElement);
}

function clearCanvas() {
  var canvasA = document.getElementById("canvas-a");
  var canvasB = document.getElementById("canvas-b");
  var contextA = canvasA.getContext("2d");
  var contextB = canvasB.getContext("2d");
  contextA.clearRect(0, 0, canvasA.width, canvasA.height);
  contextB.clearRect(0, 0, canvasB.width, canvasB.height);
}