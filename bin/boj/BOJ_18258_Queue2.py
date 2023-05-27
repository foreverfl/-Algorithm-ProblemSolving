from collections import deque
import sys

deq = deque()

N = int(input())
for _ in range(N):
    command = sys.stdin.readline()
    if "push" in command:
        tmp = command.split()
        num = int(tmp[1])
        deq.append(num)
    elif "pop" in command:
        if (deq):
            print(deq.popleft())
        else:
            print(-1)
    elif "size" in command:
        print(len(deq))
    elif "empty" in command:
        if (deq):
            print(0)
        else:
            print(1)
    elif "front" in command:
        if (deq):
            print(deq[0])
        else:
            print(-1)
    elif "back" in command:
        if (deq):
            print(deq[-1])
        else:
            print(-1)
