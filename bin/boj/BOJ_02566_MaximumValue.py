array = [[0] * 9 for _ in range(9)]

max = -1
r, c = 0, 0
for i in range(9):
    tmp = list(map(int, input().split()))
    for j in range(9):
        array[i][j] = tmp[j]
        if (array[i][j] >= max):
            r = i + 1
            c = j + 1
            max = array[i][j]

print(max)
print(r, c)
