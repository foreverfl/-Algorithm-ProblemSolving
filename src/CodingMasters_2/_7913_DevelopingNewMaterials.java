package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7913_DevelopingNewMaterials {

    static class Material implements Comparable<Material> {
        int type;
        int quantity;

        Material(int type, int quantity) {
            this.type = type;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(Material o) {
            return Integer.compare(this.quantity, o.quantity);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Material[] arr = new Material[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = new Material(i, Integer.parseInt(input[i]));
        }

        int before = -1;
        while (true) {
            Arrays.sort(arr);
            if (arr[2].type == before) { // 이전과 같은 타입의 액체는 섞을 수 없음
                before = arr[1].type;
                arr[1].quantity--;
            } else {
                before = arr[2].type;
                arr[2].quantity--;
            }

            if (isPossible(arr)) {
                System.out.println("YES");
                System.exit(0);
            }

            if (isOver(arr)) {
                System.out.println("NO");
                System.exit(0);
            }

        }
    }

    public static boolean isPossible(Material[] arr) {
        if (arr[0].quantity == arr[1].quantity && arr[1].quantity == arr[2].quantity)
            return true;

        return false;
    }

    public static boolean isOver(Material[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].quantity == 0) {
                return true;
            }
        }
        return false;
    }
}
