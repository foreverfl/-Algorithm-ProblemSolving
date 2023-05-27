import sys


def get_divisors(n):
    divisors = []
    for i in range(1, n + 1):
        if n % i == 0:
            divisors.append(i)
    return divisors


def is_completed(n, divisors):
    if (n == (sum(divisors) - n)):
        return True
    else:
        return False


while True:
    n = int(sys.stdin.readline())

    if n == -1:
        break

    divisors = get_divisors(n)
    if (is_completed(n, divisors)):
        divisors.pop()
        res = " + ".join(map(str, divisors))
        print(n, end="")
        print(" = ", end="")
        print(res)
    else:
        print(n, "is NOT perfect.")
