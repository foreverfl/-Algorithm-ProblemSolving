package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solving_7932_MakingWindows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        long res = calcTrades(N, a, b);
        System.out.println(res);
    }

    public static long calcTrades(int N, int a, int b) {

        long trades = 0;
        int frame = 1;
        int glasses = 0;
        int window = 0;

        while (true) {
            // 창문을 제작할 수 있다면 제작하기
            // 제작해야 할 창문이 하나만 남은 경우
            if (window == N - 1 && frame > 0 && glasses == 1) { // frame을 다 써도 됨
                frame--;
                glasses--;
                window++;
            }

            // 제작해야 할 창문이 두 개 이상 남은 경우
            else if (frame > 1 && glasses == 1) { // frame이 1개는 남아야 됨
                frame--;
                glasses--;
                window++;
            }

            if (window == N)
                break;

            // 유리를 구입할 창틀을 구매
            if (glasses == 0 && frame > b) {
                glasses++;
                frame -= b;
                trades++;
            }

            // 창틀을 늘림
            else {
                frame--;
                frame += a;
            }

        }

        return trades;
    }
}
