package programmers;

import java.util.Arrays;

public class Programmers_181856_ComparingArray {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            if (arr1.length > arr2.length) {
                return 1;
            } else {
                return -1;
            }
        } else {
            int arr1_sum = Arrays.stream(arr1).sum();
            int arr2_sum = Arrays.stream(arr2).sum();
            if (arr1_sum > arr2_sum) {
                return 1;
            } else if (arr1_sum < arr2_sum) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
