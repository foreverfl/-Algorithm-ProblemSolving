import sys


def sieve_of_eratosthenes(n):
    is_prime = [True] * (n+1)
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


M = int(input())
N = int(input())

primes = sieve_of_eratosthenes(N)

filtered_primes = list(filter(lambda x: x >= M, primes))
if len(filtered_primes) == 0:
    print(-1)
    sys.exit()

print(sum(filtered_primes))
print(min(filtered_primes))
