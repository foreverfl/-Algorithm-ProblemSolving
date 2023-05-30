from collections import deque

cards = deque()

N = int(input())
for i in range(N, 0, -1):
    cards.append(i)

while len(cards) != 1:
    cards.pop()
    tmp = cards.pop()
    cards.appendleft(tmp)

print(cards[0])
