// The following lines of code was written using https://www.codepen.io


function dochange() {
  alert('clicked button');
}

function doconfirm() {
  var txt;
  var choice = confirm("Confirm an action!");
  if (choice == true) {
    txt = "You pressed OK!";
  }
  else {
    txt = "Are you sure you want to cancel?!";
  }
  alert(document.getElementById("button2").innerHTML = txt);
}

function changeColor() {
  var div1 = document.getElementById("div1");
  var div2 = document.getElementById("div2");
  div1.className = "fuchsiaback";
  div2.className = "orangeback";
}

function changeText() {
  var div1 = document.getElementById("div1");
  var div2 = document.getElementById("div2");
  div1.innerHTML = "Erste";
  div2.innerHTML = "Zweite";
}


// This an exercise from the Coursera Software Engineering Specialization
// link: https://www.coursera.org/learn/duke-programming-web/supplement/9nsBb/try-it-change-pages-interactively