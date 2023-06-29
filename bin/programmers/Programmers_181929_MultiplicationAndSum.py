def solution(num_list):
    multiple = 1
    for i in range(len(num_list)):
        multiple *= num_list[i]

    sum = 0
    for i in range(len(num_list)):
        sum += num_list[i]

    if (multiple < sum * sum):
        return 1
    else:
        return 0
