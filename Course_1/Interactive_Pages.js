// The following lines of code was written using https://www.codepen.io

function addTask () {
    var input = document.getElementById("input");
    // get current text from input field
    var newTask = input.value;
    // only add new item to list if some text was entered 
    if (newTask != "") {
        // create new HTML list item
        var item = document.createElement("li");
        // add HTML for buttons and new task text
        // Note, need to use '' because of "" in HTML
        item.innerHTML = '<input type="button" class="done" onclick="markDone(this.parentNode)"  value="&#x2713;" /> ' + '<input type="button" class="remove" onclick="remove(this.parentNode)" value="&#x2715;" /> ' + '<input type="button" class="important" onclick="important(this.parentNode)" value="&#x21;" />' + newTask;

        // add new item as part of existing list
        document.getElementById("tasks").appendChild(item); 

        /* Step 4 below here */ 
      input.value = "";
      input.placeholder = "Enter New Task";
    }
}

// change styling used for given item
function markDone (item) {
    item.className = 'finished';
}

/* Step 7 below here */
function remove (item) {
    // remove item completely from document
  if (item.className=="finished"){
    item.remove();
  }
  else {
    var txt = "Complete Task First!"
    alert(document.getElementById("del1").innerHTML=txt);
  }
}

/* Step 11 below here */
function doAbout() {
  var ddA = document.getElementById("divabout");
  ddA.innerHTML = "The Author:is \nNweke Chidimma Dominic."
  if (ddA.InnerHTML != "") {
    ddA.className = "aboutcolor"
  }
}

/* Step 14 below here */
function clearAbout() {
    var ddA = document.getElementById("divabout");
  if (ddA.innerHTML != "") {
    ddA.innerHTML = ""
  }
}

function important (item) {
    item.className = 'important';
}