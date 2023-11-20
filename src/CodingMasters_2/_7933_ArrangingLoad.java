package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7933_ArrangingLoad {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] colors = br.readLine().split(" ");

        boolean isCorrect = isCorrectInitialState(colors);

        System.out.println(isCorrect ? "possible" : "impossible");
    }

    public static boolean isCorrectInitialState(String[] colors) {
        return (colors[0].equals("R") && colors[1].equals("G") && colors[2].equals("B")) ||
                (colors[0].equals("G") && colors[1].equals("B") && colors[2].equals("R")) ||
                (colors[0].equals("B") && colors[1].equals("R") && colors[2].equals("G"));
    }
}
