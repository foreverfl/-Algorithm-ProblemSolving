N, M, K = map(int, input().split())
total = N + M - K
ans = 0
while True:
    N -= 2
    M -= 1
    total -= 3
    ans += 1

    if (N < 0 or M < 0 or total < 0):
        ans -= 1
        break

print(ans)
