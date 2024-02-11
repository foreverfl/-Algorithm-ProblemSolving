package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class abc340_A_Arithmetic_Progression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int D = Integer.parseInt(input[2]);

        StringBuilder sb = new StringBuilder();
        for (int i = A; i <= B; i += D) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
