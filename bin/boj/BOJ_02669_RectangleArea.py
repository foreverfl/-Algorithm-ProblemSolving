my_map = [[0] * 100 for _ in range(100)]


for _ in range(4):
    x1, y1, x2, y2 = map(int, input().split())

    for i in range(y1, y2):
        for j in range(x1, x2):
            my_map[i][j] = 1

ans = 0
for i in range(100):
    for j in range(100):
        if (my_map[i][j] == 1):
            ans += 1

print(ans)
