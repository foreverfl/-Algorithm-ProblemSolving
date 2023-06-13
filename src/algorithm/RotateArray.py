def rotate_array():
    idx = 1
    n = 7
    arr = [[0] * n for _ in range(n)]
    start = 0
    end = n

    while True:
        for i in range(start, end):
            arr[start][i] = idx
            idx += 1
        for i in range(start + 1, end):
            arr[i][end - 1] = idx
            idx += 1
        for i in range(end - 2, start - 1, -1):
            arr[end - 1][i] = idx
            idx += 1
        for i in range(end - 2, start, -1):
            arr[i][start] = idx
            idx += 1

        start += 1
        end -= 1
        if start >= end:
            break

    for row in arr:
        for element in row:
            print(f"{element:3d}", end=" ")
        print()


rotate_array()
