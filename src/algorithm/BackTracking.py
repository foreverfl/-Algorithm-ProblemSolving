def generate_combinations(nums):
    result = []
    backtrack(nums, [], result, 0)
    return result

def backtrack(nums, combination, result, start):
    result.append(combination[:])  # 현재 조합을 결과에 추가
    
    for i in range(start, len(nums)):
        combination.append(nums[i])
        
        backtrack(nums, combination, result, i + 1)
        
        combination.pop()  # 백트래킹 (요소 제거)

nums = [1, 2, 3]
combinations = generate_combinations(nums)

for combination in combinations:
    print(combination)