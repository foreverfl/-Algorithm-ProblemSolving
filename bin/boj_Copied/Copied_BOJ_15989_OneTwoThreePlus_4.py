MAX = 10001


def sol():
    DP = [[0] * 4 for _ in range(MAX)]
    DP[0][1] = 1
    DP[1][1] = 1
    for i in range(2, MAX):
        DP[i][1] = DP[i - 1][1]
        DP[i][2] = DP[i - 2][1] + DP[i - 2][2]
        if i >= 3:
            DP[i][3] = DP[i - 3][1] + DP[i - 3][2] + DP[i - 3][3]
    return DP


DP = sol()
T = int(input())

for _ in range(T):
    n = int(input())
    print(DP[n][1] + DP[n][2] + DP[n][3])

# reference: https://nim-code.tistory.com/133
