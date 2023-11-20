package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7925_VAT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long price = Long.parseLong(br.readLine());

        // price = supplyPrice + tax
        // tax = 0.1 * supplyPrice
        // 위의 식을 하나로 합치면
        // price = supplyPrice + 0.1 * supplyPrice
        // price = 1.1 * supplyPrice
        // 10 * price = 11 * supplyPrice
        // supplyPrice = 10 / 11 * price
        long tax = price / 11;
        long supplyPrice = price - tax;

        if (supplyPrice / 10 == tax) {
            System.out.println(supplyPrice + " " + tax);
        } else {
            System.out.println(-1);
        }
    }
}
