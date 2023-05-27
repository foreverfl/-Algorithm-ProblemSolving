N = int(input())
for i in range(N):
    if i == 0 or i == N - 1:
        for _ in range(N - i - 1):
            print(" ", end="")
        for _ in range(i * 2 + 1):
            print("*", end="")
    else:
        print(" " * (N - i - 1), end="")  # indent
        print("*", end="")
        print(" " * (i * 2 - 1), end="")  # inner
        print("*", end="")

    print()
