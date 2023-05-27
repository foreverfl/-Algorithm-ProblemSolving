N, M = map(int, input().split())
basket = list(range(1, N + 1))

for _ in range(M):
    i, j = map(int, input().split())
    i -= 1
    j -= 1
    tmp = basket[i]
    basket[i] = basket[j]
    basket[j] = tmp

print(*basket)
