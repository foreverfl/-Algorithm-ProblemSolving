package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7928_MoneyGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);

        while (true) {
            if (a == 0 || b == 0)
                break;

            if (a >= 2 * b) {
                a %= (2 * b);
            } else if (b >= 2 * a) {
                b %= (2 * a);
            } else {
                break;
            }

        }

        System.out.println(a + " " + b);
    }

}
