import sys


def divide_and_conquer(arr, row, col, size):
    global cnt_minus_1, cnt_0, cnt_1
    isSame = True
    first_color = arr[row][col]
    for i in range(row, row + size):
        for j in range(col, col + size):
            if paper[i][j] != first_color:
                isSame = False

    if isSame:
        if first_color == -1:
            cnt_minus_1 += 1

        elif first_color == 0:
            cnt_0 += 1

        else:
            cnt_1 += 1

    else:
        divided_size = size // 3
        divide_and_conquer(paper, row, col, divided_size)
        divide_and_conquer(paper, row, col + divided_size, divided_size)
        divide_and_conquer(paper, row, col + divided_size * 2, divided_size)
        divide_and_conquer(paper, row + divided_size, col, divided_size)
        divide_and_conquer(paper, row + divided_size,
                           col + divided_size, divided_size)
        divide_and_conquer(paper, row + divided_size, col +
                           divided_size * 2, divided_size)
        divide_and_conquer(paper, row + divided_size * 2, col, divided_size)
        divide_and_conquer(paper, row + divided_size * 2,
                           col + divided_size, divided_size)
        divide_and_conquer(paper, row + divided_size * 2,
                           col + divided_size * 2, divided_size)


N = int(sys.stdin.readline())
paper = []
cnt_minus_1 = 0
cnt_0 = 0
cnt_1 = 0

for _ in range(N):
    row = list(map(int, sys.stdin.readline().split()))
    paper.append(row)

divide_and_conquer(paper, 0, 0, N)

print(cnt_minus_1)
print(cnt_0)
print(cnt_1)
