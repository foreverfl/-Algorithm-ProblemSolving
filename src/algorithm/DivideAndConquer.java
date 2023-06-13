package algorithm;

public class DivideAndConquer {
    public static int findMax(int[] arr, int left, int right) {
        if (left == right) {
            // 배열에 하나의 요소만 남은 경우
            return arr[left];
        } else {
            int mid = (left + right) / 2;
            int max1 = findMax(arr, left, mid); // 왼쪽 부분 배열에서 최대값 찾기
            int max2 = findMax(arr, mid + 1, right); // 오른쪽 부분 배열에서 최대값 찾기
            return Math.max(max1, max2); // 두 부분 배열의 최대값 중 더 큰 값 반환
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 9, 1, 5, 8, 4, 6};
        int max = findMax(arr, 0, arr.length - 1);
        System.out.println("최대값: " + max);
    }
}
