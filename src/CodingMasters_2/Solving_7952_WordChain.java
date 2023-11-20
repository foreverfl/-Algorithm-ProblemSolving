package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solving_7952_WordChain {

    public static List<List<String>> wordsChains = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        backtrack(words, new ArrayList<>());
        int maxLen = -1;
        for (List<String> wordChain : wordsChains) {
            maxLen = Math.max(maxLen, calcLength(wordChain));
        }

        System.out.println(maxLen % 2 == 1 ? "gayeong" : "nayeong");

    }

    public static void backtrack(String[] words, List<String> currentChain) {
        if (currentChain.size() == words.length) {
            wordsChains.add(new ArrayList<>(currentChain));
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                currentChain.add(words[i]);
                backtrack(words, currentChain);
                currentChain.remove(currentChain.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static int calcLength(List<String> wordChain) {
        int len = 1;
        for (int i = 1; i < wordChain.size(); i++) {
            if (wordChain.get(i - 1).charAt(wordChain.get(i - 1).length() - 1) == wordChain.get(i).charAt(0)) {
                len++;
            } else {
                break;
            }
        }

        return len;
    }

}