package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7867_pangram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(isPangram(input) ? "YES" : "NO");

    }

    public static boolean isPangram(String str) {
        boolean[] check = new boolean[26];
        char[] arr = str.toLowerCase().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            check[arr[i] - 'a'] = true;
        }

        for (int i = 0; i < check.length; i++) {
            if (!check[i])
                return false;
        }

        return true;
    }
}
