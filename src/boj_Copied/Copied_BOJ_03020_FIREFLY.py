import sys
INF = float('inf')


N, H = map(int, sys.stdin.readline().split())
top = [0] * 500001
bottom = [0] * 500001

# index 구간에서 끝나는 종유석, 석순의 길이
for i in range(N):
    h = int(sys.stdin.readline())
    if i % 2 == 0:
        bottom[h] += 1
    else:
        top[H - h + 1] += 1

# index 구간에 만나는 종유석, 석순의 장애물 개수
for i in range(1, H + 1):
    top[i] += top[i - 1]
    bottom[H - i] += bottom[H - i + 1]

ans = INF # 장애물의 최솟값
cnt = 0 # ans의 개수

for i in range(1, H + 1):
    if top[i] + bottom[i] < ans:
        cnt = 1
        ans = top[i] + bottom[i]
    elif top[i] + bottom[i] == ans:
        cnt += 1

print(ans, cnt)

# reference: https://hyeo-noo.tistory.com/310
