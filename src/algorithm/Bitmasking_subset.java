package algorithm;

public class Bitmasking_subset {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };
        int n = array.length;

        // 모든 부분집합을 순회
        for (int i = 0; i < (1 << n); i++) { // 2^n(0 ~ 2^n - 1)만큼 순회
            System.out.print("{ ");

            // 각 원소가 부분집합에 포함되는지 확인
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(array[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
}
