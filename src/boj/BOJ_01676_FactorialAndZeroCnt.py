import math

N = int(input())
result = math.factorial(N)
result_str = str(result)

ans = 0
for char in reversed(result_str):
    if char == '0':
        ans += 1
    else:
        break

print(ans)
