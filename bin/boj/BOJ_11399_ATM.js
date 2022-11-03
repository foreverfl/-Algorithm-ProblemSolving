const input = require('fs').readFileSync(__dirname + '\\input.txt').toString().split('\n');
const map_sorted = input[1].split(" ").sort(function (a, b) { return a - b });
let sum = 0;
for (let i = 0; i < map_sorted.length; i++) {
    sum += map_sorted[i] * (map_sorted.length - i);
}
console.log(sum);