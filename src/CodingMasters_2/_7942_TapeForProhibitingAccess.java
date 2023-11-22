package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7942_TapeForProhibitingAccess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] polygon = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            polygon[i][0] = Integer.parseInt(st.nextToken());
            polygon[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] points = new int[M][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean allInside = true;
        for (int[] point : points) {
            if (!isInsidePolygon(polygon, point)) {
                allInside = false;
                break;
            }
        }

        System.out.println(allInside ? "YES" : "NO");
    }

    public static boolean isInsidePolygon(int[][] polygon, int[] point) {
        int N = polygon.length;
        for (int i = 0; i < N; i++) {
            int[] p1 = polygon[i];
            int[] p2 = polygon[(i + 1) % N];

            if (crossProduct(p1, p2, point) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static int crossProduct(int[] p1, int[] p2, int[] p) {
        int x1 = p2[0] - p1[0];
        int y1 = p2[1] - p1[1];
        int x2 = p[0] - p1[0];
        int y2 = p[1] - p1[1];

        return x1 * y2 - y1 * x2;
    }
}
