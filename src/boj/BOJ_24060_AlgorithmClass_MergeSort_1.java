package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_24060_AlgorithmClass_MergeSort_1 {
    private static int cnt;
    private static int ans;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int N = inputs[0];
        K = inputs[1];
        int[] A = new int[N];
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        cnt = 0;
        ans = -1;
        mergeSort(A, 0, N - 1);
        System.out.println(ans);
    }

    private static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private static void merge(int[] A, int p, int q, int r) {
        int i = p; // 첫 번째 하위 배열의 현재 인덱스
        int j = q + 1; // 두 번째 하위 배열의 현재 인덱스
        int t = 0; // 임시 배열의 인덱스
        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t] = A[i];
                i++;
            } else {
                tmp[t] = A[j];
                j++;
            }
            t++;
        }

        while (i <= q) { // 왼쪽 배열 부분이 남은 경우
            tmp[t] = A[i];
            i++;
            t++;
        }

        while (j <= r) { // 오른쪽 배열 부분이 남은 경우
            tmp[t] = A[j];
            j++;
            t++;
        }

        i = p;
        t = 0;
        while (i <= r) { // 결과를 A[p..r]에 저장
            A[i] = tmp[t];
            cnt++;
            if (cnt == K) {
                ans = A[i];
                break;
            }
            i++;
            t++;
        }
    }
}
