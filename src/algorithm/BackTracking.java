package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> combinations = generateCombinations(nums);
        
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
    
    public static List<List<Integer>> generateCombinations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }
    
    private static void backtrack(int[] nums, List<Integer> combination, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(combination)); // 현재 조합을 결과에 추가
        
        for (int i = start; i < nums.length; i++) {
            combination.add(nums[i]); 
            
            backtrack(nums, combination, result, i + 1);
            
            combination.remove(combination.size() - 1); // 백트래킹 (요소 제거)
        }
    }
}
