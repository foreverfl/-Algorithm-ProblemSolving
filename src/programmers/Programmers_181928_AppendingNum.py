def solution(num_list):
    even = []
    odd = []
    for i in num_list:
        if i % 2 == 0:
            even.append(str(i))
        else:
            odd.append(str(i))

    even_str = ''.join(even)
    odd_str = ''.join(odd)

    answer = int(even_str) + int(odd_str)
    return answer


print(solution([3, 4, 5, 2, 1]))
