package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7879_GrayScale {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hexCode = br.readLine().substring(1);
        String red = hexCode.substring(0, 2);
        String green = hexCode.substring(2, 4);
        String blue = hexCode.substring(4, 6);

        int average = (int) Math
                .round((Integer.parseInt(red, 16) + Integer.parseInt(green, 16) + Integer.parseInt(blue, 16)) / 3.0);
        String averageAsHex = String.format("%02X", average);
        String grayScaleHex = averageAsHex + averageAsHex + averageAsHex;
        System.out.println("#" + grayScaleHex);
    }
}
