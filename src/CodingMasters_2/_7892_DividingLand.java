package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7892_DividingLand {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(findMinimumLines(N));

    }

    public static int findMinimumLines(int N) {
        int totalAreas = 1;
        int lines = 0;

        while (totalAreas < N) {
            lines++;
            totalAreas += lines;
        }

        return lines;
    }
}
