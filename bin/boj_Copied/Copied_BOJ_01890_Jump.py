import sys


def count_paths(board, N):
    dp = [[0] * N for _ in range(N)]
    dp[0][0] = 1

    for i in range(N):
        for j in range(N):
            val = board[i][j]
            if val > 0:
                if 0 <= i + val < N:
                    dp[i + val][j] += dp[i][j]
                if 0 <= j + val < N:
                    dp[i][j + val] += dp[i][j]

    return dp


N = int(sys.stdin.readline())
board = []

for i in range(N):
    tmp = list(map(int, sys.stdin.readline().split()))
    board.append(tmp)

dp = count_paths(board, N)
print(dp[-1][-1])

# reference: https://chul2-ing.tistory.com/75
