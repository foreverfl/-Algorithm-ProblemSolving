def find_subarray_sum(nums, target):
    window_sum = 0
    window_start = 0

    for window_end in range(len(nums)):
        window_sum += nums[window_end]

        while window_sum > target:
            window_sum -= nums[window_start]
            window_start += 1

        if window_sum == target:
            return [window_start, window_end]

    return None


nums = [1, 4, 2, 10, 2, 3, 1, 0, 20]
target = 15

subarray_indices = find_subarray_sum(nums, target)

if subarray_indices is not None:
    start = subarray_indices[0]
    end = subarray_indices[1]
    print("연속된 부분 배열의 합이 목표값과 일치하는 경우가 있습니다.")
    print("첫 인덱스:", start)
    print("끝 인덱스:", end)
else:
    print("일치하는 부분 배열을 찾지 못했습니다.")