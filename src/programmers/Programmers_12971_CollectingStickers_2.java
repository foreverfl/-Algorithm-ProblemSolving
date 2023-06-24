package programmers;

public class Programmers_12971_CollectingStickers_2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(solution(new int[] {1, 3, 2, 5, 4}));
    }

    public static int solution(int sticker[]) {
        int length = sticker.length;
        if (length == 1) {
            return sticker[0];
        }

        if (length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        // 첫 번째 스티커를 뜯는 경우
        int[] dp1 = new int[length - 1];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // 두 번째 스티커부터 뜯는 경우
        int[] dp2 = new int[length];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[length - 2], dp2[length - 1]);
    }
}
