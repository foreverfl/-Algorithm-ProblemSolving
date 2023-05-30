def power(base, exponent, modulus):
    if exponent == 0:
        return 1
    elif exponent % 2 == 0:
        half = power(base, exponent // 2, modulus)
        return (half * half) % modulus
    else:
        half = power(base, (exponent - 1) // 2, modulus)
        return (base * half * half) % modulus


A, B, C = map(int, input().split())
res = power(A, B, C)
print(res)
