def solution(arr):
    ans = []
    for i in range(len(arr)):
        for _ in range(arr[i]):
            ans.append(arr[i])

    return ans
