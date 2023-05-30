package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_05904_MooGame {

    static char[] s1 = {'m', 'o', 'o'};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        findMooChar(n, 1, 3);
    }

    private static void findMooChar(int n, int k, int len) { // k: 수열의 깊이
        int newLen = len * 2 + k + 3;
        if (n <= 3) {
            System.out.println(s1[n - 1]);
            System.exit(0);
        }
        if (newLen < n) {
            findMooChar(n, k + 1, newLen);
        } else {
            if (n > len && n <= len + k + 3) {
                if (n - len != 1)
                    System.out.println("o");
                else
                    System.out.println("m");
                System.exit(0);
            } else {
                findMooChar(n - (len + k + 3), 1, 3);
            }
        }
    }
}

// reference: https://excited-hyun.tistory.com/110