import sys


def generate_prefix_sum(matrix):
    rows, cols = len(matrix), len(matrix[0])
    prefix_sum = [[0] * cols for _ in range(rows)]

    for i in range(rows):
        for j in range(cols):
            if i > 0:
                top_sum = prefix_sum[i - 1][j]
            else:
                top_sum = 0

            if j > 0:
                left_sum = prefix_sum[i][j - 1]
            else:
                left_sum = 0

            if i > 0 and j > 0:
                diagonal_sum = prefix_sum[i - 1][j - 1]
            else:
                diagonal_sum = 0

            prefix_sum[i][j] = matrix[i][j] + top_sum + left_sum - diagonal_sum

    return prefix_sum


def get_submatrix_sum(prefix_sum, row1, col1, row2, col2):
    sum_total = prefix_sum[row2][col2]

    if row1 > 0:
        sum_total -= prefix_sum[row1 - 1][col2]

    if col1 > 0:
        sum_total -= prefix_sum[row2][col1 - 1]

    if row1 > 0 and col1 > 0:
        sum_total += prefix_sum[row1 - 1][col1 - 1]

    return sum_total


N, M = map(int, sys.stdin.readline().split())
table = [0 * N for _ in range(N)]

for i in range(N):
    table[i] = list(map(int, sys.stdin.readline().split()))

prefix_sum = generate_prefix_sum(table)

for _ in range(M):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    print(get_submatrix_sum(prefix_sum, x1 - 1, y1 - 1, x2 - 1, y2 - 1))
