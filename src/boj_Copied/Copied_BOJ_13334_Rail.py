import heapq
import sys

n = int(sys.stdin.readline())
inputQ = []
for _ in range(n):
    h, o = map(int, sys.stdin.readline().split())
    if h > o:
        inputQ.append((o, h))
    else:
        inputQ.append((h, o))
d = int(sys.stdin.readline())

inputQ.sort(key=lambda x: (x[1], x[0]))  # 끝 점 o를 기준으로 정렬

maxSize = 0
pq = []

for i in range(len(inputQ)):
    iR, iL = inputQ[i][1], inputQ[i][0]

    # 사람의 길이가 d보다 작으면 일단 선분 L 안에 들어올 수 있는 후보니까 그 시작점을 우선순위 큐에 넣는다.
    if iR - iL <= d:
        heapq.heappush(pq, iL)
    else:
        continue

    while pq:
        # 가능한 왼쪽 시작점 후보들이 있는 pq 에서 하나를 뽑아서
		# 현재 살펴보고 있는 i번째 사람의 오른쪽 끝값과의 거리를 계산하고
		# 그 거리가 d 이하이면 나가서 다른 인풋을 계속 보며,
		# d 보다 큰 거리이면 후보에서 빼버린다. 
        tmp = pq[0]
        if iR - tmp <= d:
            break
        else:
            heapq.heappop(pq)

    maxSize = max(maxSize, len(pq))

print(maxSize)

# reference: https://chanhuiseok.github.io/posts/baek-28/