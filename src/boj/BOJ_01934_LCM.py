import math

T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    print(math.lcm(A, B))
