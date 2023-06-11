n, m, result = 1, 1, 1
arr = [[0] * 51 for _ in range(51)]

n, m = map(int, input().split())
for i in range(n):
    input_str = input()
    for j in range(len(input_str)):
        arr[i][j] = int(input_str[j])

for i in range(n):
    for j in range(m):
        cnt = 0
        k = 1
        while True:
            if (j + k) >= m or (i + k) >= n:
                break
            if arr[i][j] == arr[i][j + k] == arr[i + k][j] == arr[i + k][j + k]:
                if cnt < k:
                    cnt = k
            k += 1
        result = max(result, cnt + 1)

print(result * result)

# reference: https://gusdnr69.tistory.com/42
