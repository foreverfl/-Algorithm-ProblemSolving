let fs = require('fs');
let input = fs.readFileSync(__dirname + '\\input.txt').toString().split(' ');
let a = input[0];
let b = input[1];

function convert_to_max(input) {
    const arr = input.split('');
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === "5") {
            arr[i] = "6"
        }
    }

    const result_string = arr.join('');
    const result = parseInt(result_string);
    return result;
}


function convert_to_min(input) {
    const arr = input.split('');
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === "6") {
            arr[i] = "5"
        }
    }

    const result_string = arr.join('');
    const result = parseInt(result_string);
    return result;
}

let max = convert_to_max(a) + convert_to_max(b);
let min = convert_to_min(a) + convert_to_min(b);

console.log(min + ' ' + max);