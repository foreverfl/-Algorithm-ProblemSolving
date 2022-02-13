let input = require('fs').readFileSync('/dev/stdin').toString();

function arithmeticalProgression(input) {
    let cnt = 0;
    for (i = 1; i <= input; i++) {
        let j = i.toString();
        if (j.length <= 2) {
            cnt++;
        } else if (j[0] - j[1] === j[1] - j[2]) {
            cnt++;
        }
    }
    console.log(cnt);
}
arithmeticalProgression(input);