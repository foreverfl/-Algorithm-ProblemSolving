package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solving_7937_ShufflingCards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long K = Long.parseLong(input[1]);

        int[] shuffleRule = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 0부터 시작하는 인덱스에 맞추어 조정
        for (int i = 0; i < shuffleRule.length; i++) {
            shuffleRule[i]--;
        }

        int[] original = IntStream.rangeClosed(1, N).toArray();
        int[] cards = original.clone();

        long shuffleCount = 0;
        do {
            cards = shuffleCards(cards, shuffleRule);
            shuffleCount++;
        } while (!Arrays.equals(cards, original));

        long actualShuffles = K % shuffleCount;// 실제 필요한 섞기 횟수

        cards = original.clone();
        for (long i = 0; i < actualShuffles; i++) {
            cards = shuffleCards(cards, shuffleRule);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(cards[i] + " ");
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
