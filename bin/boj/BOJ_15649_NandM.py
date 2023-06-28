def backtrack(N, M, list, used):
    if len(list) == M:
        print(' '.join(map(str, list)))
        return

    for i in range(1, N + 1):
        if used[i]:
            continue

        used[i] = True
        list.append(i)
        backtrack(N, M, list, used)
        list.pop()
        used[i] = False


N, M = map(int, input().split())
backtrack(N, M, [], [False] * (N + 1))
