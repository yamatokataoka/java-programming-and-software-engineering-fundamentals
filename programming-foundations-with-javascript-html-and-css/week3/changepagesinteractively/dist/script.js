function changeColor () {
  // For each div, create a variable that gets that div
  var cabbage = document.getElementById("cabbage");
  var carrot = document.getElementById("carrot");
  
  // Change each div’s class
  cabbage.className = "pug";
  carrot.className = "patriot";
}

// create a new function changeText()
function changeText () {
  // Access each div element by its ID;
  var cabbage = document.getElementById("cabbage");
  var carrot = document.getElementById("carrot");
  
  // Use the .innerHTML method to change the text to something new inside each div.
  cabbage.innerHTML = "pug";
  carrot.innerHTML = "patriot";
}

function changeTextColor () {
  var cabbage = document.getElementById("cabbage");
  var carrot = document.getElementById("carrot");
  
  cabbage.style.color = "yellow";
  carrot.style.color = "#ff7f50";
}

function changeTextOnButton () {
  var button = document.getElementById("button");
  
  button.value = "Oh No";
}