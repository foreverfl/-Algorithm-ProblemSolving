import sys

N = int(sys.stdin.readline())
plugs = [int(sys.stdin.readline()) for _ in range(N)]
total = sum(plugs)
max_computers = total - (N - 1)
print(max_computers)
