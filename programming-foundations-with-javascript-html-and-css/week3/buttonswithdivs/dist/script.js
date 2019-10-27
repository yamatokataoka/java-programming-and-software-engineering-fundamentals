// add an alert
function change () {
   alert('clicked button by JS');
}

function confirmTest () {
  // Create a variable, choice that gets the result of user input using the confirm method.
  var choice = confirm("which you want to choose?");
  // create a variable, message
  var message;

  // Add a condition
  if (choice == true) {
    message = "Yes, you pressed OK!"
  }
  else {
    message = "Are you sure you want to cancel?" 
  }
  // Create an alert box that displays message.
  alert(message);
}