package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class _7937_ShufflingCards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long K = Long.parseLong(input[1]);

        int[] shuffleRule = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 0부터 시작하는 인덱스에 맞추어 조정
        for (int i = 0; i < shuffleRule.length; i++) {
            shuffleRule[i]--;
        }

        boolean[] visited = new boolean[N];
        int[] result = new int[N];
        int[] original = IntStream.range(0, N).toArray();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                List<Integer> cycle = new ArrayList<>();
                int current = i;

                // 사이클 찾기
                while (!visited[current]) {
                    visited[current] = true;
                    cycle.add(current);
                    current = shuffleRule[current];
                }

                // 사이클 내에서 K번 섞은 후 위치 계산
                int cycleSize = cycle.size();
                long actualShuffles = K % cycleSize;

                int[] temp = original.clone();
                for (int j = 0; j < actualShuffles; j++) {
                    temp = shuffleCards(temp, shuffleRule);
                }

                for (int j = 0; j < cycleSize; j++) {
                    result[cycle.get(j)] = temp[cycle.get(j)] + 1; // 인덱스 조정
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] shuffleCards(int[] cards, int[] shuffleRule) {
        int[] shuffled = new int[cards.length];

        for (int i = 0; i < cards.length; i++) {
            shuffled[shuffleRule[i]] = cards[i];
        }

        return shuffled;
    }

}