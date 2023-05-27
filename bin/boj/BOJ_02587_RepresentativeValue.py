numbers = []

for _ in range(5):
    numbers.append(int(input()))

numbers = sorted(numbers)
average = sum(numbers) // 5
median = numbers[2]

print(average)
print(median)
