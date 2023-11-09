package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class _7873_InputtingPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String pattern = "^010-\\d{4}-\\d{4}$";
        if (Pattern.matches(pattern, S)) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }

    }
}
