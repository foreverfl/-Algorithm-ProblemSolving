def find_max(arr, left, right):
    if left == right:
        return arr[left]
    else:
        mid = (left + right) // 2
        max1 = find_max(arr, left, mid)  # 왼쪽 부분 배열에서 최대값 찾기
        max2 = find_max(arr, mid + 1, right)  # 오른쪽 부분 배열에서 최대값 찾기
        return max(max1, max2)  # 두 부분 배열의 최대값 중 더 큰 값 반환


arr = [3, 7, 2, 9, 1, 5, 8, 4, 6]
max_value = find_max(arr, 0, len(arr) - 1)
print("최대값:", max_value)