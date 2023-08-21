package CodingMasters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _7255_NutritionScore {
    public static int N;
    public static boolean[] visited;
    public static int[][] score;
    public static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        score = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(input[j]);
            }
        }

        combination(0, 0);

        System.out.println(minDifference);
    }

    public static void combination(int start, int count) {
        if (count == N / 2) {
            List<Integer> list_1 = new ArrayList<>();
            List<Integer> list_2 = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    list_1.add(i);
                } else {
                    list_2.add(i);
                }
            }

            int score_1 = calculateScore(list_1);
            int score_2 = calculateScore(list_2);

            int difference = Math.abs(score_1 - score_2);
            minDifference = Math.min(minDifference, difference);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    public static int calculateScore(List<Integer> list) {
        int totalScore = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int a = list.get(i);
                int b = list.get(j);
                totalScore += score[a][b] + score[b][a];
            }
        }

        return totalScore;
    }
}
