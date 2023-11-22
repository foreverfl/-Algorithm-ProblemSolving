package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solving_7952_WordChain {

    public static boolean[] visited;
    public static int maxLen = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            backtrack(words, 1, words[i]);
            visited[i] = false;
        }

        System.out.println(maxLen % 2 == 1 ? "gayeong" : "nayeong");

    }

    public static void backtrack(String[] words, int currentLength, String before) {
        if (currentLength > maxLen) {
            maxLen = currentLength;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isValid(before, words[i])) {
                visited[i] = true;
                backtrack(words, currentLength + 1, words[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean isValid(String before, String next) {
        return before.isEmpty() || before.charAt(before.length() - 1) == next.charAt(0);
    }

}