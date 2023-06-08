package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Copied_BOJ_10800_ColorBall {

    static class Ball implements Comparable<Ball> {
        int weight, color, idx;

        public Ball(int weight, int color, int idx) {
            this.weight = weight;
            this.color = color;
            this.idx = idx;
        }

        @Override
        public int compareTo(Ball other) {
            if (this.weight == other.weight) {
                return Integer.compare(this.color, other.color);
            }
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MAX = 200001;

        Ball[] arr = new Ball[MAX];
        int[] ans = new int[MAX];
        int[] colors = new int[MAX];
        int[] sizes = new int[MAX];

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            int color = Integer.parseInt(tmp[0]);
            int weight = Integer.parseInt(tmp[1]);
            arr[i] = new Ball(weight, color, i);
        }
        Arrays.sort(arr, 0, N);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int weight = arr[i].weight;
            int color = arr[i].color;
            int idx = arr[i].idx;

            colors[color] += weight;
            sizes[weight] += weight;
            sum += weight;

            ans[idx] = sum - colors[color] - sizes[weight] + weight;
            if (i != 0 && arr[i - 1].color == color && arr[i - 1].weight == weight) {
                ans[idx] = ans[arr[i - 1].idx];
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(ans[i]);
        }
    }
}

// reference: https://tnwlswkd.tistory.com/100
