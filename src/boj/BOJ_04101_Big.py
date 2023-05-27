import sys

while True:
    A, B = map(int, input().split())

    if A == 0 & B == 0:
        sys.exit()

    if (A > B):
        print("Yes")
    else:
        print("No")
