N = int(input())
res = list(map(int, input().split()))

ans = 0
tmp = 0
now = 0
for i in range(N):
    if res[i] == 1:
        now += 1
        tmp += now
    else:
        ans += tmp
        tmp = 0
        now = 0

if (tmp != 0):
    ans += tmp

print(ans)
