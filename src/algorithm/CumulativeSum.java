package algorithm;

public class CumulativeSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        // 누적 합 배열 계산
        int[] cumSum = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            cumSum[i] = cumSum[i - 1] + arr[i - 1];
        }

        // 특정 구간의 합 계산 예시 (2번째부터 4번째 요소까지의 합)
        int start = 2; // 시작 인덱스 (1부터 시작한다고 가정)
        int end = 4; // 끝 인덱스
        int sum = cumSum[end] - cumSum[start - 1];

        System.out.println("Sum of elements from " + start + " to " + end + " is: " + sum);
    }
}
