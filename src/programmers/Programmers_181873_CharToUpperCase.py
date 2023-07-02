def solution(my_string, alp):
    answer = ''
    for char in my_string:
        if (char == alp):
            answer += char.upper()
        else:
            answer += char
    return answer


print(solution('programmers', 'p'))
