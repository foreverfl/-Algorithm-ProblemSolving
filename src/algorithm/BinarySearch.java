package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        
        int index = binarySearch(arr, target);
        
        if (index != -1) {
            System.out.println("찾는 값의 인덱스: " + index);
        } else {
            System.out.println("배열에 찾는 값이 없습니다.");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + right / 2;
            
            if (arr[mid] == target) {
                return mid; // 찾는 값의 인덱스 반환
            } else if (arr[mid] < target) {
                left = mid + 1; // 오른쪽 반 배열 탐색
            } else {
                right = mid - 1; // 왼쪽 반 배열 탐색
            }
        }
        
        return -1; // 찾는 값이 배열에 없을 경우
    }
}
