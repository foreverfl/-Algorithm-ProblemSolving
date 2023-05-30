array = [[0] * 100 for _ in range(100)]


def fill_paper(x, y):
    for i in range(10):
        for j in range(10):
            array[x + i - 1][y + j - 1] = 1


N = int(input())
for _ in range(N):
    x, y = map(int, input().split())
    fill_paper(x, y)

ans = 0
for i in range(100):
    for j in range(100):
        if array[i][j] == 1:
            ans += 1

print(ans)
