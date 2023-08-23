package CodingMasters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7169_KoreanCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        if (A >= 200) {
            System.out.print("A");
        } else if (A >= 180) {
            System.out.print("B");
        } else if (A >= 150) {
            System.out.print("C");
        } else {
            System.out.print("D");
        }
    }
}
