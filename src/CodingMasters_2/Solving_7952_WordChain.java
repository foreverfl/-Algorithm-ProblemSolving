package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solving_7952_WordChain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        System.out.println(predictWinner(words));
    }

    public static String predictWinner(String[] words) {
        boolean[] used = new boolean[words.length];
        int result = playGame(words, used, ' ', 0);
        return result == 1 ? "gayeong" : "nayeong";
    }

    public static int playGame(String[] words, boolean[] used, char lastChar, int turn) {
        boolean flag = false; // 다음 차례의 단어를 찾았는지 여부
        for (int i = 0; i < words.length; i++) {
            if (!used[i] && (words[i].charAt(0) == lastChar || lastChar == ' ')) {
                used[i] = true;
                if (playGame(words, used, words[i].charAt(words[i].length() - 1), 1 - turn) == turn) {

                    used[i] = false;
                    return turn;
                }
                used[i] = false;
                flag = true;
            }
        }
        return flag ? 1 - turn : turn;
    }
}