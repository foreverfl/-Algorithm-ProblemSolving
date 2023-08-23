package CodingMasters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7180_AreaOfCircle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double result = N * N * 3.14;

        if (result == (int) result) {
            System.out.printf("%d", (int) result);
        } else {
            String formatted = String.format("%.5f", result);
            System.out.println(formatted.replaceAll("0*$", "").replaceAll("\\.$", ""));
        }
    }
}
