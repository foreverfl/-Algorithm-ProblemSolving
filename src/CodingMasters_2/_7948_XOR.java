package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7948_XOR {

    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findSubsets(arr, 0, 0, 0);
        System.out.println(ans);
    }

    public static void findSubsets(int[] array, int index, int currentXOR, int selectedCount) {
        if (index == array.length) {
            if (currentXOR == 0 && selectedCount > 1) {
                ans++;
            }
            return;
        }

        // 현재 요소를 포함하지 않는 경우
        findSubsets(array, index + 1, currentXOR, selectedCount);

        // 현재 요소를 포함하는 경우
        findSubsets(array, index + 1, currentXOR ^ array[index], selectedCount + 1);
    }

}