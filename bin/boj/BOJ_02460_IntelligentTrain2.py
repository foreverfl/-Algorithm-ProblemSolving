now = 0
ans = 0
for _ in range(10):
    train_out, train_in = map(int, input().split())
    now -= train_out
    now += train_in
    ans = max(ans, now)

print(ans)
