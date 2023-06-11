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


primes = sieve_of_eratosthenes(123456 * 2 + 1)

while True:
    num = int(sys.stdin.readline())

    if num == 0:
        break

    cnt = 0
    for i in range(num + 1, 2 * num + 1):
        if i in primes:
            cnt += 1
    print(cnt)
