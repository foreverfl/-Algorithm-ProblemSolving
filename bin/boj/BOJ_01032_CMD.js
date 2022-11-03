const fs = require('fs');
const input = fs.readFileSync(__dirname + '\\input.txt').toString().split('\n');
const T = parseInt(input[0]);
var result = input[1];
for (let i = 2; i <= T; i++) {
    for (let j = 0; j < result.length; j++) {
        if (result[j] !== input[i][j]) {
            result = result.substring(0, j) + '?' + result.substring(j + 1);
        }
    }   
}
console.log(result);