def solution(num_list):
    answer = [0] * (len(num_list) + 1)
    last = 0
    if num_list[-1] > num_list[-2]:
        last = num_list[-1] - num_list[-2]
    else:
        last = 2 * num_list[-1]

    for i in range(len(num_list)):
        answer[i] = num_list[i]
    answer[-1] = last

    return answer