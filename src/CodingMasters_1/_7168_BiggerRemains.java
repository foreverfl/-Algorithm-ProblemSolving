package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7168_BiggerRemains {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A = N % 5;
        int B = N % 7;
        System.out.println(A > B ? A : B);
    }
}
