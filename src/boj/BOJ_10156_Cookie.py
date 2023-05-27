K, N, M = map(int, input().split())
price = K * N
ans = price - M
if ans < 0:
    ans = 0

print(ans)
