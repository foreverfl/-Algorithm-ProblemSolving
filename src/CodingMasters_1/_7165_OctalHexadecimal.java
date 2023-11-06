package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7165_OctalHexadecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int decimal = Integer.parseInt(br.readLine());
        String octal = Integer.toOctalString(decimal);
        String hexadecimal = Integer.toHexString(decimal).toUpperCase();
        System.out.println(octal + " " + hexadecimal);
    }
}
