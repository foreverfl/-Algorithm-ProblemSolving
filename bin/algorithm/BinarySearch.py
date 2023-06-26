def binary_search(arr, target):
    left = 0
    right = len(arr) - 1
    
    while left <= right:
        mid = (left + right) // 2
        
        if arr[mid] == target:
            return mid  # 찾는 값의 인덱스 반환
        elif arr[mid] < target:
            left = mid + 1  # 오른쪽 반 배열 탐색
        else:
            right = mid - 1  # 왼쪽 반 배열 탐색
    
    return -1  # 찾는 값이 배열에 없을 경우

arr = [1, 3, 5, 7, 9, 11, 13]
target = 7

index = binary_search(arr, target)

if index != -1:
    print("찾는 값의 인덱스:", index)
else:
    print("배열에 찾는 값이 없습니다.")