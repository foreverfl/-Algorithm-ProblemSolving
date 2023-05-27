N = int(input())
first_blank = N - 1
for i in range(N):
    for _ in range(first_blank):
        print(" ", end="")

    for j in range(i + 1):
        print("* ", end="")

    first_blank -= 1

    print()
