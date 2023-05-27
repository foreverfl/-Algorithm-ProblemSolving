import math


def calculate_possible_coordinates(x1, y1, r1, x2, y2, r2):
    distance = math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)

    if distance == 0 and r1 == r2:
        return -1
    elif distance > r1 + r2 or distance < abs(r1 - r2):
        return 0
    elif distance == r1 + r2 or distance == abs(r1 - r2):
        return 1
    else:
        return 2


N = int(input())
for _ in range(N):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    result = calculate_possible_coordinates(x1, y1, r1, x2, y2, r2)
    print(result)
