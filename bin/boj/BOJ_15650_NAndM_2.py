def backtrack(N, M, start, list):
    if len(list) == M:
        print(' '.join(map(str, list)))
        return

    for i in range(start, N + 1):
        list.append(i)
        backtrack(N, M, i + 1, list)
        list.pop()


N, M = map(int, input().split())
backtrack(N, M, 1, [])
