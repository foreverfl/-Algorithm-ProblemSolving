let fs = require('fs');
let input = fs.readFileSync(__dirname + '\\input.txt').toString().split(' ');
let sc = input[0];

let arr = sc.split("");
let cnt = 0;
let e = "";
for (let i = 0; i < arr.length; i++) {
    if (arr[i] === "e") {
        cnt++;
    }
}
for (let i = 0; i < cnt * 2; i++) {
    e += "e";
}

console.log("h" + e + "y");