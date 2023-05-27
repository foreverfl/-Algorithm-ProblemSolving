N, M = map(int, input().split())
A = [[0 for _ in range(M)] for _ in range(N)]
B = [[0 for _ in range(M)] for _ in range(N)]
res = [[0 for _ in range(M)] for _ in range(N)]

for i in range(N):
    row = list(map(int, input().split()))
    for j in range(M):
        A[i][j] = row[j]

for i in range(N):
    row = list(map(int, input().split()))
    for j in range(M):
        B[i][j] = row[j]


for i in range(N):
    for j in range(M):
        res[i][j] = A[i][j] + B[i][j]

for row in res:
    print(*row)
