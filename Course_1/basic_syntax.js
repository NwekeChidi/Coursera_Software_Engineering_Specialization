// This code is written using the IDE developed by https://www.dukelearntoprogram.com//course1/example/index.php


// write your code here
var x = 3;
var y = 4;
var z = x + 2*y;

print(x);
print(y);
print(z);

var x = y;
var y = z;
var z = y + x;

print(x);
print(y);
print(z);

var image = new SimpleImage("chapel.png");
print(image);

//Experimenting with functions

function square(x){
    // function that squares two numbers
    var ans = x*x;
    return ans;
}

var y = square(4);
print(y);

function cube(x){
    // function that calculates the cube of a given number
    var ans = x*x*x;
    return ans;
}

var z = cube(4);
print(z);

function addNumbers(x, y, z){
    // function that adds three numbers together
    var ans = x + y + z;
    return ans;
}

var x = addNumbers(4, 5, 6);
print(x);

function addStrings(x, y){
    // function that add two strings together
    var ans = x + y;
    return ans;
}

var x = addStrings("boy", "girl");
print(x);

function getHeight(image){
    var height = image.getHeight();
    return height;
}

function getWidth(image){
    var width = image.getWidth();
    return width;
}

var x = getHeight(image);
print(x);
var y = getWidth(image);
print(y);
print("Image size: ", y, "x", x);






// This an exercise from the Coursera Software Engineering Specialization
// link: https://www.coursera.org/learn/duke-programming-web/supplement/drrbY/try-it-using-variables-methods-and-functions