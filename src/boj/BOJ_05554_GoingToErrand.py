times = []
for _ in range(4):
    line = int(input())
    times.append(line)

total = sum(times)
print(total // 60, total % 60, end='\n\n')
