def calculate_N(proper_divisors):
    min_divisor = min(proper_divisors)
    max_divisor = max(proper_divisors)
    N = min_divisor * max_divisor
    return N


N = input()
proper_divisors = list(map(int, input().split()))

result = calculate_N(proper_divisors)
print(result)
