import queue

N = int(input())
q = queue.Queue()
for i in range(1, N + 1):
    q.put(i)

while q.qsize() > 1:
    print(q.get(), end=' ')
    q.put(q.get())

print(q.get())
