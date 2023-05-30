def sieve_of_eratosthenes(n):
    is_prime = [True] * (n + 1)
    is_prime[0] = is_prime[1] = False

    p = 2
    while p * p <= n:
        if is_prime[p]:
            for i in range(p * p, n + 1, p):
                is_prime[i] = False
        p += 1

    primes = []
    for i in range(2, n + 1):
        if is_prime[i]:
            primes.append(i)

    return primes


M, N = map(int, input().split())
decimals = sieve_of_eratosthenes(N)
ans = list()
for i in range(len(decimals)):
    if decimals[i] >= M and decimals[i] <= N:
        ans.append(decimals[i])

for num in ans:
    print(num)
