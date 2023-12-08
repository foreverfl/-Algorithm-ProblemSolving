package algorithm;

public class Kadanes_Algorithm {
    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(arr));
    }

    public static int maxSubArraySum(int[] arr) {
        int size = arr.length;
        int maxSoFar = Integer.MIN_VALUE; // 현재 인덱스 i에서 끝나는 연속된 부분 배열의 최대 합
        int maxEndingHere = 0;

        for (int i = 0; i < size; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

            // 음수 추가를 배제함
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
