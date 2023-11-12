package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class _7878_Mukjjibba {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int len = lcm(N, M);

        int[] arr_1 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr_2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] new_arr_1 = extendArray(arr_1, len);
        int[] new_arr_2 = extendArray(arr_2, len);

        boolean gameIsStarted = false;
        boolean firstIsWinning = false;
        boolean firstIsWinner = false;
        boolean gameIsOver = true; // 기본적으로 게임은 끝날 것이라고 예상

        for (int i = 0; i < len; i++) {
            if (!gameIsStarted) {
                if (new_arr_1[i] == new_arr_2[i]) {
                    continue;
                } else {
                    gameIsStarted = true;
                    if (checkFirstIsWinner(new_arr_1[i], new_arr_2[i])) {
                        firstIsWinning = true;
                    } else {
                        firstIsWinning = false;
                    }
                }
            } else {
                if (new_arr_1[i] == new_arr_2[i]) {
                    if (firstIsWinning) {
                        firstIsWinner = true;
                    } else {
                        firstIsWinner = false;
                    }
                    break;
                } else {
                    if (checkFirstIsWinner(new_arr_1[i], new_arr_2[i])) {
                        firstIsWinning = true;
                    } else {
                        firstIsWinning = false;
                    }
                }
            }

            if (i == len - 1) {
                gameIsOver = false; // 계속 비겨서 게임이 끝나지 않는 경우
            }
        }

        if (!gameIsStarted || !gameIsOver) {
            System.out.println(0);
        } else {
            System.out.println(firstIsWinner == true ? 1 : 2);
        }
    }

    public static boolean checkFirstIsWinner(int a, int b) {
        if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] extendArray(int[] arr, int newLength) {
        int[] newArr = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            newArr[i] = arr[i % arr.length];
        }
        return newArr;
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
