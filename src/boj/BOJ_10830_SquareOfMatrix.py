MOD = 1000


def multiplyMatrices(matrix1, matrix2):
    n = len(matrix1)
    result = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            for k in range(n):
                result[i][j] = (result[i][j] + matrix1[i]
                                [k] * matrix2[k][j]) % MOD

    return result


def power(matrix, exponent):
    n = len(matrix)
    result = [[0] * n for _ in range(n)]

    if exponent == 0:
        for i in range(n):
            result[i][i] = 1
        return result

    if exponent == 1:
        for i in range(n):
            for j in range(n):
                matrix[i][j] %= MOD
        return matrix

    if exponent % 2 == 0:
        halfPower = power(matrix, exponent // 2)
        result = multiplyMatrices(halfPower, halfPower)
    else:
        halfPower = power(matrix, (exponent - 1) // 2)
        result = multiplyMatrices(
            matrix, multiplyMatrices(halfPower, halfPower))

    return result


N, B = map(int, input().split())
matrix = []
for _ in range(N):
    row = list(map(int, input().split()))
    matrix.append(row)

result = power(matrix, B)

for row in result:
    print(*row)
