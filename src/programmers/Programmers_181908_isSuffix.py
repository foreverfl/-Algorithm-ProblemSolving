def solution(my_string, is_suffix):
    if (len(is_suffix) > len(my_string)):
        return 0

    arr_1 = list(my_string[::-1])
    arr_2 = list(is_suffix[::-1])

    for i in range(len(arr_2)):
        if arr_1[i] != arr_2[i]:
            return 0

    return 1
