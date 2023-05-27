N = int(input())
for _ in (range(N)):
    r, e, c = map(int, input().split())
    tmp = e - c
    if (r > tmp):
        print("do not advertise")
    elif (r < tmp):
        print("advertise")
    else:
        print("does not matter")
