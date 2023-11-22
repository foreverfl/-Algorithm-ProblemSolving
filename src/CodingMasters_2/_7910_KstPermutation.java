package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7910_KstPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] permutation = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            permutation[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            permutation = nextPermutation(permutation, N);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(permutation[i] + " ");
        }
    }

    public static int[] nextPermutation(int[] permutation, int N) {
        // 순열의 끝에서부터 시작하여, 처음으로 감소하는 순서의 숫자를 찾음
        int i = N - 2;
        while (i >= 0 && permutation[i] >= permutation[i + 1]) {
            i--;
        }

        // 이미 사전 순으로 가장 마지막 순열인 경우, 첫 번째 순열로 돌아감
        if (i == -1) {
            for (int j = 0; j < N; j++) {
                permutation[j] = j + 1;
            }
            return permutation;
        }

        // 다시 순열의 끝에서부터 시작하여, 위에서 찾은 숫자보다 큰 첫 번째 숫자를 찾음
        int j = N - 1;
        while (permutation[i] >= permutation[j]) {
            j--;
        }

        // 두 숫자의 위치를 교환
        swap(permutation, i, j);

        // 교환된 숫자 뒤의 순열을 오름차순으로 정렬
        int start = i + 1;
        int end = N - 1;
        while (start < end) {
            swap(permutation, start, end);
            start++;
            end--;
        }

        return permutation;
    }

    public static void swap(int[] permutation, int i, int j) {
        int temp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = temp;
    }
}
