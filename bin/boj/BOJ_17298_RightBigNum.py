import sys

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))

result = [-1] * N
stack = []

for i in range(N):
    while stack and A[i] > A[stack[-1]]:
        result[stack.pop()] = A[i]
    stack.append(i)

sys.stdout.write(' '.join(map(str, result)))
