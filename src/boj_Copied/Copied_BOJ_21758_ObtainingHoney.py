n = int(input())
arr = [0] * (n + 1)
sum = [0] * (n + 1)

arr[1:n+1] = map(int, input().split())
for i in range(1, n + 1):
    sum[i] = arr[i] + sum[i - 1]

ans = 0
for i in range(2, n): # 벌, 벌, 꿀통
    ans = max(ans, (sum[n] - arr[1] - arr[i]) + (sum[n] - sum[i]))

for i in range(2, n): # 꿀통, 벌, 벌
    ans = max(ans, sum[i - 1] + (sum[n] - arr[n] - arr[i]))

for i in range(2, n): # 벌, 꿀통, 벌
    ans = max(ans, (sum[i] - arr[1]) + (sum[n] - sum[i - 1] - arr[n]))

print(ans)

# reference: https://david0506.tistory.com/68