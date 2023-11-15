package algorithm;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3; // 윈도우 크기
        System.out.println("최대 합: " + findMaxSumSubArray(numbers, k));
    }

    public static int findMaxSumSubArray(int[] numbers, int k) {
        int maxSum = 0;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < numbers.length; end++) {
            windowSum += numbers[end]; // 윈도우의 끝에 요소 추가

            // 윈도우의 크기가 k일 때
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum); // 최대 합 갱신
                windowSum -= numbers[start]; // 윈도우의 시작에 있는 요소 제거
                start++; // 윈도우의 시작점 이동
            }
        }

        return maxSum;
    }
}
