package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solving_7937_ShufflingCards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long K = Long.parseLong(input[1]);

        int[] shuffle = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 순열을 0부터 시작하는 인덱스에 맞추어 조정
        for (int i = 0; i < shuffle.length; i++) {
            shuffle[i]--;
        }

        int[] result = shuffleCards(N, shuffle, K);

        for (int i = 0; i < N; i++) {
            System.out.print((result[i] + 1) + " "); // 1부터 시작하는 형태로 출력
        }
    }

    // 카드를 섞는 함수
    public static int[] shuffleCards(int N, int[] shuffle, long K) {
        int[] current = shuffle.clone();
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = i; // 초기 순열 설정
        }

        while (K > 0) {
            if (K % 2 == 1) {
                result = applyShuffle(result, current);
            }
            current = applyShuffle(current, current);
            K /= 2;
        }

        return result;
    }

    // 순열을 적용하는 함수
    public static int[] applyShuffle(int[] permutation, int[] shuffle) {
        int[] newPermutation = new int[permutation.length];
        for (int i = 0; i < permutation.length; i++) {
            newPermutation[i] = permutation[shuffle[i]];
        }
        return newPermutation;
    }
}
