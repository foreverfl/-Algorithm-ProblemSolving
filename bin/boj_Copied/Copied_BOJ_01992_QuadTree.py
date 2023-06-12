import sys


def division(start_row, start_col, size):
    if size == 1:
        print(pic[start_row][start_col], end="")
        return
    num = pic[start_row][start_col]

    for row in range(start_row, start_row + size):
        for col in range(start_col, start_col + size):
            if num != pic[row][col]:
                print("(", end="")
                size //= 2
                division(start_row, start_col, size)
                division(start_row, start_col + size, size)
                division(start_row + size, start_col, size)
                division(start_row + size, start_col + size, size)
                print(")", end="")
                return

    print(pic[start_row][start_col], end="")
    return


N = int(sys.stdin.readline())
pic = [[0] * N for _ in range(N)]
for i in range(N):
    pic[i] = list(map(int, sys.stdin.readline().rstrip()))

division(0, 0, N)

# reference: https://jjini-3-coding.tistory.com/17
