MOD = 1000000009
MAX = 1000010

T = int(input())
for _ in range(T):
    N = int(input())
    DP = [0] * MAX
    DP[1] = 1
    DP[2] = 2
    DP[3] = 4
    for i in range(4, N + 1):
        DP[i] = (DP[i - 1] + DP[i - 2] + DP[i - 3]) % MOD
    print(DP[N] % MOD)
