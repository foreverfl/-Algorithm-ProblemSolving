package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7881_AppreciateAPainting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[4][4];
        for (int i = 0; i < 4; i++) {
            map[i] = br.readLine().toCharArray();
        }

        char[][][] possibles = new char[][][] { { { 'X', 'X' }, { 'X', 'X' } }, { { 'O', 'X' }, { 'X', 'X' } },
                { { 'X', 'O' }, { 'X', 'X' } }, { { 'X', 'X' }, { 'O', 'X' } }, { { 'X', 'X' }, { 'X', 'O' } } };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char[][] tmp = new char[2][2];
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        tmp[k][l] = map[i + k][j + l];
                    }
                }
                for (int k = 0; k < possibles.length; k++) {
                    if (Arrays.deepEquals(possibles[k], tmp)) {
                        System.out.println("yes");
                        System.exit(0);
                    }
                }

            }
        }

        System.out.println("no");
    }
}
