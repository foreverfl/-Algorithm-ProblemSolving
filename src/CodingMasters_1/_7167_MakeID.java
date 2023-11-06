package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7167_MakeID {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.matches("[a-zA-Z]{1,20}")) {
            System.out.println("P");
        } else {
            System.out.println("I");
        }
    }
}
