const fs = require('fs');
const input = fs.readFileSync(__dirname + '\\input.txt').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);
const arrA = [];
const arrB = [];

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    arrA[i] = input[i].trim().split('').map(Number);
    arrB[i] = input[i+N].trim().split('').map(Number);
  }
}

function solution(n, m) {
  let count = 0;

  // flip
  for (let i = 0; i < n - 2; i++) {
    for (let j = 0; j < m - 2; j++) {
      if (arrA[i][j] !== arrB[i][j]) {
        for (let k = i; k <= i + 2; k++) {
          for (let h = j; h <= j + 2; h++) {
            arrA[k][h] = 1 - arrA[k][h];
          }
        }
        count += 1;
      }
    }
  }

  // when impossible
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (arrA[i][j] !== arrB[i][j]) {
        return -1;
      }
    }
  }

  return count;
}

console.log(solution(N, M));