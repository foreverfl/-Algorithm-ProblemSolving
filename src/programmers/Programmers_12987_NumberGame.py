def solution(A, B):
    A.sort()
    B.sort()

    answer = 0
    b_index = 0

    for num in A:
        while b_index < len(B) and B[b_index] <= num:
            b_index += 1

        if b_index == len(B):
            break

        answer += 1
        b_index += 1

    return answer


print(solution([5, 1, 3, 7], [2, 2, 6, 8]))
print(solution([2, 2, 2, 2], [1, 1, 1, 1]))
