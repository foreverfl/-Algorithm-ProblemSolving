let input = (require('fs').readFileSync(0, 'utf-8') + '').trim().split('\n');

let t = +input[0];
input = input.slice(1);
let [m, n, k] = [0];
let field;

const dfs = (x, y) => {
    if (x < 0 || x >= m || y < 0 || y >= n) return;
    if (field[x][y]) {
        field[x][y] = 0;
        dfs(x - 1, y);
        dfs(x, y - 1);
        dfs(x + 1, y);
        dfs(x, y + 1);
    }
}

for (let i = 0; i < t; i++) {
    [m, n, k] = input[0].split(' ').map(v => +v);
    field = Array.from(Array(m), () => Array(n).fill(0));
    for (let j = 0; j < k; j++) {
        let [x, y] = input[j + 1].split(' ').map(v => +v);
        field[x][y] = 1;
    }

    a = a.slice(k + 1);

    let cnt = 0;
    for (let j = 0; j < m; j++) {
        for (let k = 0; k < n; k++) {
            if (field[j][k]) {
                dfs(j, k);
                cnt++;
            }
        }
    }
    console.log(cnt);
}