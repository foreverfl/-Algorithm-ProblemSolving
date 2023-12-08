package programmers;

public class Programmers_12980_JumpAndTeleport {
    public int solution(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;

        int cnt = 1;
        while (n != 2) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                cnt++;
            }
        }

        return cnt;
    }
}
