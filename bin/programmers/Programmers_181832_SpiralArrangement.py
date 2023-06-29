def solution(n):
    idx = 1
    n = n
    ans = [[0] * n for _ in range(n)]
    start = 0
    end = n

    while True:
        for i in range(start, end):
            ans[start][i] = idx
            idx += 1
        for i in range(start + 1, end):
            ans[i][end - 1] = idx
            idx += 1
        for i in range(end - 2, start - 1, -1):
            ans[end - 1][i] = idx
            idx += 1
        for i in range(end - 2, start, -1):
            ans[i][start] = idx
            idx += 1

        start += 1
        end -= 1
        if start >= end:
            break

    return ans
