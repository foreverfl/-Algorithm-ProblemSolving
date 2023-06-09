package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_09184_FunnyFunctionImplementation {
    static HashMap<String, Integer> memo = new HashMap<>();

    public static int w(int a, int b, int c) {
        String key = a + "," + b + "," + c;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result;
        if (a <= 0 || b <= 0 || c <= 0) {
            result = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            result = w(20, 20, 20);
        } else if (a < b && b < c) {
            result = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            result = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }

        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = w(a, b, c);
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
        }

        br.close();
    }
}
