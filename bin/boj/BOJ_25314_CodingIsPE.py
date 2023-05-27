N = int(input())
quotient, remainder = divmod(N, 4)
cnt = quotient
if remainder != 0:
    quotient += 1

ans = ""
for _ in range(cnt):
    ans += "long "

ans += "int"
print(ans.strip())
