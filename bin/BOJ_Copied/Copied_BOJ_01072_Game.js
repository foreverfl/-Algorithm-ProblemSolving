const [X, Y] = require("fs").readFileSync(__dirname + '\\input.txt').toString().trim().split(" ").map(Number); // It is equals with the 'Integer.parseInt'.
const Z = getPercent(X, Y);
let low = 0,
    high = 1000000000,
    answer = -1;

while (low <= high) {
    let mid = Math.floor((low + high) / 2);

    if (getPercent(X + mid, Y + mid) != Z) {
        answer = mid;
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}

console.log(answer);

function getPercent(X, Y) {
    return Math.floor((100 * Y) / X);
}