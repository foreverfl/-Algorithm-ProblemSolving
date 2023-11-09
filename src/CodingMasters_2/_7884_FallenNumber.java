package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7884_FallenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[] A_check = new int[10];
        int[] B_check = new int[10];

        for (int i = 0; i < A.length(); i++) {
            char now = A.charAt(i);
            A_check[now - '0']++;
        }

        for (int i = 0; i < B.length(); i++) {
            char now = B.charAt(i);
            B_check[now - '0']++;
        }

        boolean areEqual = Arrays.equals(A_check, B_check);
        if (areEqual) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
