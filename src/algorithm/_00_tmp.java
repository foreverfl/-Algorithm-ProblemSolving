package algorithm;

public class _00_tmp {
    public static void main(String[] args) {
        int n = 987643125;
        int tmp = 0;

        while (true) {
            tmp = n;
            n = recursion(n);

            if (tmp == n) { // tmp와 n이 같다면 루프 탈출
                break;
            }
        }

        System.out.println(n);

    }

    public static int recursion(int num) {
        if (num % 3 == 0) {
            return num / 3 + 3;
        } else if (num % 5 == 0) {
            return num / 5 + 5;
        } else if (num % 7 == 0) {
            return num / 7 + 7;
        } else {
            return num;
        }

    }
}
