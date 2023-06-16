import sys

N, M = map(int, sys.stdin.readline().split())
maze = [[0] * M for _ in range(N)]
dp = [[0] * M for _ in range(N)]

for i in range(N):
    tmp = sys.stdin.readline().split()
    for j in range(M):
        maze[i][j] = int(tmp[j])

dp[0][0] = maze[0][0]

for i in range(1, M):
    dp[0][i] = maze[0][i] + dp[0][i - 1]

for i in range(1, N):
    dp[i][0] = maze[i][0] + dp[i - 1][0]

for i in range(1, N):
    for j in range(1, M):
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + maze[i][j]

print(dp[N - 1][M - 1])
