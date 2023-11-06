package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7955_Quaternion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long c = Long.parseLong(input[2]);
        long d = Long.parseLong(input[3]);

        input = br.readLine().split(" ");
        long w = Long.parseLong(input[0]);
        long x = Long.parseLong(input[1]);
        long y = Long.parseLong(input[2]);
        long z = Long.parseLong(input[3]);

        long res1 = a * w - b * x - c * y - d * z;
        long res2 = a * x + b * w + c * z - d * y;
        long res3 = a * y - b * z + c * w + d * x;
        long res4 = a * z + b * y - c * x + d * w;

        System.out.println(res1 + " " + res2 + " " + res3 + " " + res4);
    }
}
