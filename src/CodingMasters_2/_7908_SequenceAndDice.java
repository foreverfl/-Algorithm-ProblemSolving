package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _7908_SequenceAndDice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> probabilities = calculateProbabilities();
        // System.out.println(probabilities);

        int maxExpectedScore = Integer.MIN_VALUE;
        StringBuilder kValues = new StringBuilder();

        for (int K = 1; K <= N; K++) {
            int expectedScore = 0;

            for (int T = 3; T <= 18; T++) {
                int index = K + T - 1;
                int score = index < N ? numbers[index] : -100;
                expectedScore += (probabilities.get(T)) * score;
            }

            if (expectedScore > maxExpectedScore) {
                maxExpectedScore = expectedScore;
                kValues = new StringBuilder(String.valueOf(K));
            } else if (expectedScore == maxExpectedScore) {
                kValues.append(" ").append(K);
            }
        }

        System.out.println(maxExpectedScore);
        System.out.println(kValues.toString());
    }

    public static Map<Integer, Integer> calculateProbabilities() {
        Map<Integer, Integer> probabilities = new HashMap<>();
        for (int i = 3; i <= 18; i++) {
            probabilities.put(i, 0);
        }

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    int sum = i + j + k;
                    probabilities.put(sum, probabilities.get(sum) + 1);
                }
            }
        }
        return probabilities;
    }
}
