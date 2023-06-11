import sys

N = int(sys.stdin.readline())
pic = [[0] * N for _ in range(N)]
for i in range(N):
    pic[i] = list(map(int, sys.stdin.readline().rstrip()))

print(pic)
