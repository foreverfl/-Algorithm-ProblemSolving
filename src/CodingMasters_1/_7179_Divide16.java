package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7179_Divide16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N / 16);
    }
}
