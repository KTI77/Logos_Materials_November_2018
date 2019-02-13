// alert('Hello World');

// var firstName = 'John';
// // let, const
// let age = 28;
// let isValid = true;
// let user;
// let sqrt = Math.sqrt(-9);
// let address = {};

// console.log(firstName + ' ' + age);
// console.log(typeof firstName);
// console.log(typeof age);
// console.log(typeof isValid);
// console.log(typeof user);
// console.log(sqrt);
// console.log(typeof address);

// const num1 = 20;
// const num2 = 10;
// let res;

// res = num1 + num2;
// res = num1 - num2;
// res = num1 * num2;
// res = num1 / num2;
// res = num1 % num2;
// console.log(res);

// let a = parseFloat(prompt('Enter number1: '));
// let b = parseFloat(prompt('Enter number2: '));

// function add(num1 = 0, num2 = 0) {
//     return num1 + num2;
// }
// console.log('RES: ' + add(a, b));

// function sayHello() {
//     console.log('hello');
// }

// function sayHello(name = 'Default', age = 0) {
//     // if (typeof name == 'undefined') {
//     //     name = 'Default';
//     // }
//     console.log('Hello, ' + name + ' ' + age);
// }
// sayHello('dsfsdf', 345);

// function pow(a = 0) {
//     return a * a;
// }
// console.log(pow());

// if (100 == '100') {
//     console.log('true');
// }

// if (20.0 === '20') {
//     console.log('true');
// } else {
//     console.log('false');
// }

let person = {
    firstName : 'Adam',
    lastName : 'Adamas',
    age : 49,
    email : 'myemail@gmail.com',
    hobbies : ['hobby1', 'hobby2', 'hobby2'],
    address : {
        city : 'Lviv',
        street : 'My street 11/2'
    }
};

let res;
res = person.email;
res = person.lastName;
res = person['lastName'];
res = person.address.city;

console.log(person);




