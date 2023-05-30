def josephus(n, k):
    circle = list(range(1, n + 1))
    result = []
    idx = k - 1

    while circle:
        idx %= len(circle)
        result.append(circle.pop(idx))
        idx += k - 1

    return result


N, K = map(int, input().split())

sequence = josephus(N, K)

print('<' + ', '.join(map(str, sequence)) + '>')
