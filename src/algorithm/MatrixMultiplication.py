def multiply_matrices(matrix1, matrix2):
    n = len(matrix1)
    result = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            for k in range(n):
                result[i][j] += matrix1[i][k] * matrix2[k][j]

    return result


matrix1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
matrix2 = [[10, 11, 12], [13, 14, 15], [16, 17, 18]]

result = multiply_matrices(matrix1, matrix2)

# 결과 행렬 출력
for row in result:
    print(" ".join(str(element) for element in row))