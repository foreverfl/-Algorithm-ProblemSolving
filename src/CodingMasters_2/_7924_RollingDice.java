package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7924_RollingDice {
    public static class Dice {
        int east, south, west, north, top, bottom;

        public Dice(int east, int south, int west, int north, int top, int bottom) {
            this.east = east;
            this.south = south;
            this.west = west;
            this.north = north;
            this.top = top;
            this.bottom = bottom;
        }

        public Dice() {

        }

        void rollEast() {
            int temp = top;
            top = west;
            west = bottom;
            bottom = east;
            east = temp;
        }

        void rollSouth() {
            int temp = top;
            top = north;
            north = bottom;
            bottom = south;
            south = temp;
        }

        void rollWest() {
            int temp = top;
            top = east;
            east = bottom;
            bottom = west;
            west = temp;
        }

        void rollNorth() {
            int temp = top;
            top = south;
            south = bottom;
            bottom = north;
            north = temp;
        }
    }

    public static int[][] map;
    public static int W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 너비
        H = Integer.parseInt(st.nextToken()); // 높이
        map = new int[H][W];

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        map[Y][X] = dice.bottom; // 시작 값

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = X, ny = Y;

            if (dir == 1) { // 동쪽
                dice.rollEast();
                nx = X + 1;
                if (isValid(nx, ny))
                    X = nx;

            } else if (dir == 2) { // 남쪽
                dice.rollSouth();
                ny = Y + 1;
                if (isValid(nx, ny))
                    Y = ny;

            } else if (dir == 3) { // 서쪽
                dice.rollWest();
                nx = X - 1;
                if (isValid(nx, ny))
                    X = nx;

            } else if (dir == 4) { // 북쪽
                dice.rollNorth();
                ny = Y - 1;
                if (isValid(nx, ny))
                    Y = ny;
            }

            if (isValid(X, Y)) {
                map[Y][X] = dice.bottom; // 주사위 바닥면으로 숫자 갱신
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < W && y >= 0 && y < H;
    }
}
