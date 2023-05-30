sum = 0

def divide_and_conquer(size, start):
    global sum
    if size == 2:
        # print("values:", cows[start], cows[start + 1])
        sum += cows[start] * cows[start + 1]
    elif size == 1:
        return
    else:
        half = size // 2
        if size % 2 == 0: # 짝수인 경우
            divide_and_conquer(half, start)  # 왼쪽
            divide_and_conquer(half, start + half)  # 오른쪽
        else:  # 홀수인 경우
            divide_and_conquer(half + 1, start)  # 왼쪽
            divide_and_conquer(half, start + half + 1)  # 오른쪽
        

N = int(input())
cows = list(range(1, N + 1))
divide_and_conquer(N, 0)
print(sum)