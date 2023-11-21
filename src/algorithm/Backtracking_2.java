package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Backtracking_2 {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };
        List<Integer> currentSubset = new ArrayList<>();
        generateSubsets(array, 0, currentSubset);
    }

    public static void generateSubsets(int[] array, int index, List<Integer> currentSubset) {
        if (index == array.length) {
            System.out.println(currentSubset);
            return;
        }

        // 현재 요소를 포함하지 않는 경우
        generateSubsets(array, index + 1, new ArrayList<>(currentSubset));

        // 현재 요소를 포함하는 경우
        currentSubset.add(array[index]);
        generateSubsets(array, index + 1, new ArrayList<>(currentSubset));
    }
}
