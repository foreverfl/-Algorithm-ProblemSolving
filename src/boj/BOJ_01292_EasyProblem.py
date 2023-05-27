progression = []
repeat = 1
cnt = 0
while True:
    for i in range(repeat):
        cnt += 1
        progression.append(repeat)

    repeat += 1
    if (cnt >= 1000):
        break

A, B = map(int, input().split())
print(sum(progression[A-1:B]))
