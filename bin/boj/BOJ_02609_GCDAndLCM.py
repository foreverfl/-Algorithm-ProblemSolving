import math

a, b = map(int, input().split())

gcd_reseult = math.gcd(a, b)
lcm_result = (a * b) // gcd_reseult

print(gcd_reseult)
print(lcm_result)
