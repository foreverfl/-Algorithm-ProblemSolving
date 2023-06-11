import sys


def sieve_of_eratosthenes(n):
    is_prime = [True] * (n + 1)
    is_prime[0] = is_prime[1] = False

    p = 2
    while p * p <= n:
        if is_prime[p]:
            for i in range(p * p, n + 1, p):
                is_prime[i] = False
        p += 1

    primes = set()
    for i in range(2, n + 1):
        if is_prime[i]:
            primes.add(i)

    return primes


primes = sieve_of_eratosthenes(10000)

T = int(sys.stdin.readline())
for _ in range(T):
    n = int(sys.stdin.readline())
    partition = [0, 10000]
    diff = 0
    for i in range(n):
        if i in primes and n - i in primes:
            a = max(i, n - i)
            b = min(i, n - i)
            diff = a - b
            if partition[1] - partition[0] > diff:
                partition[0] = b
                partition[1] = a

    print(partition[0], partition[1])
