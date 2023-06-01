people = set()
people.add("ChongChong")

N = int(input())
for _ in range(N):
    A, B = input().split()
    if (A in people):
        people.add(B)
    if (B in people):
        people.add(A)

print(len(people))
