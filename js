<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .container {
          text-align: center;
          margin: 0 auto;
        }
        button {
          width: 120px;
          height: 30px;
          color: white;
          background-color: seagreen;
        }
        .digital-clock {
          font-weight: bold;
          font-size: 50px;
          width: 300px;
          margin: auto;
        }
        .clockClass {
          padding: 10px 20px;
          background-color: gainsboro;
          color: floralwhite;
          line-height: 1;
        }
    </style>
</head>
<body>
    

        <div class="container">
            <h2 id="h2Elem">This is H2 element</h2>
            <p id="pElem">This is P element</p>
            <span id="spanElem">This is SPAN element</span>
            <button id="btnElem" type="button" onclick="changeStyle()">Change style</button>
          
            <hr>
          
            <div class="digital-clock">
                <p id="clock" class="clockClass">
            </div>
          
            <hr>
          
            <input type="text" id="searchValue">
            <button type="button" id="btnSearch">Search</button>
          
        </div>

    <script src="main.js"></script>
</body>
</html>


//console.log("Hello World");

// var, let, const
// var firstName = 'John';
// var age = 34;
// var isValid = true;
// var user;
// var sqrt = Math.sqrt(-9);
// var address = {};

// console.log(typeof firstName);
// console.log(typeof age);
// console.log(typeof isValid);
// console.log(typeof user);
// console.log(sqrt);
// console.log(typeof address);

// age = firstName;
// console.log(age);

// let a = 10;
// let b = 20;
// let res;
// res = a + b;
// res = a - b;
// res = a * b;
// res = a / b;
// res = a % b;
// console.log(res);

// let res;
// res = Math.PI;
// res = Math.round(2.5); // 2.4
// res = Math.ceil(2.1);
// res = Math.floor(2.9);
// res = Math.sqrt(81);
// res = Math.pow(2, 5);
// console.log(res);

//var CONSTANT = 'TOMMY';
// const name = 'Tommy';
// //name = 'John';
// let res;
// res = name + ' ' + 'Johnson';
// res = name.concat(' ', 'Johnson');
// res = name.length;
// res = name.indexOf('m');
// res = name.lastIndexOf('m');
// res = name.charAt(3);
// res = name.replace('y', 'Z');
// console.log(res);

// function sayHello() {
//     console.log('Hello');
// } 

/* Calculator */
/*
function sayHello(name = 'Default') {
    // if (typeof name == 'undefined') {
    //     name = 'Default';
    // }
    console.log('Hello, ' + name);
} 
//sayHello();

let a = parseFloat(prompt('Enter number1: '));
let b = parseFloat(prompt('Enter number2: '));

function add(num1 = 0, num2 = 0) {
    return num1 + num2;
}

function sub(num1 = 0, num2 = 0) {
    return num1 - num2;
}

function mul(num1 = 0, num2 = 0) {
    return num1 * num2;
}

function div(num1 = 0, num2 = 1) {
    // if (num2 == 0) {
    //     console.log('Div by ZERO');
    //     return;
    // }
    return num1 / num2;
 }

console.log('SUM = ' + add(a, b));
console.log('SUB = ' + sub(a, b));
console.log('MUL = ' + mul(a, b));
console.log('DIV = ' + div(a, b));
*/

/*
const person = {
    firstName : 'Adam',
    lastName : 'Adams',
    age: 45,
    email: 'adam@gmail.com',
    hobbies: ['game', 'programming'],
    address: {
        city: 'Lviv',
        street: 'Lvivska'
    }
};

let res;
res = person.email;
res = person['lastName'];
res = person.hobbies;
res = person.address;
res = person.address.city;

console.log(res);
console.log(person);

*/

function changeStyle() {
    document.getElementById('h2Elem').style.color = '#01ff0f';
    document.getElementById('pElem').style.backgroundColor = 'orange';
    document.getElementById('spanElem').setAttribute('style', 'font-size: 25px; color: blue;');
    document.getElementById('btnElem').style.transform = 'rotate(15deg)';
  
  }
  
  function createClock() {
    let today = new Date();
    let h = today.getHours();
    let m = today.getMinutes();
    let s = today.getSeconds();
  
    h = checkTime(h);
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('clock').innerHTML = h + ':' + m + ':' + s;
  
    setTimeout(createClock, 500);
  }
  
  function checkTime(i) {
    if(i < 10) {
      i = '0' + i;
    }
    return i;
  }
  
  createClock();
//   setTimeout(function() {
//       createClock();
//   }, 50);
  
  document.getElementById('btnSearch').addEventListener('click', function() {
    let searchWord = document.getElementById('searchValue');
    // https://www.google.com.ua/search?q=qwery
    // https://stackoverflow.com/search?q=jpa
    window.open('https://stackoverflow.com/search?q=' + searchWord.value);
  });

