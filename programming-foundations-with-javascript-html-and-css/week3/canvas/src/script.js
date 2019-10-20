function changeColor () {
  var cabbage = document.getElementById("cabbage");
  var carrot = document.getElementById("carrot");
  
  cabbage.className = "pug";
  carrot.className = "patriot";
}

function doPug () {
  var carrot = document.getElementById("carrot");
  
  var context = cabbage.getContext("2d");
  context.clearRect(0, 0, carrot.width, carrot.height);
  
  carrot.style.backgroundColor = "LightGray";
}

function doPatriot () {
  // Get the left canvas element. 
  var carrot = document.getElementById("carrot");
  
  // use the style.backgroundColor property to change the background color
  carrot.style.backgroundColor = "#3F7FBF";
  
  // get the context of the canvas.
  var context = carrot.getContext("2d");
  
  // Draw a rectangle.
  context.fillStyle = "#ff7f50";
  context.fillRect(10, 10, 60, 60);
  context.fillRect(80, 10, 60, 60);
  
  // adding text to your canvas.
  context.fillStyle = "yellow";
  context.font = "20px YuGothic";
  context.fillText("Hello from Canvas", 10, 90);
}