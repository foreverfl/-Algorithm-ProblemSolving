package programmers;

public class Programmers_12929_TheNumberOfValidParentheses {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int[] answer = new int[1]; // pass-by-reference
        backTrack(0, 0, n, answer);
        return answer[0];
    }

    public static void backTrack(int open, int close, int n, int[] res) {
        if (open == n && close == n) {
            res[0]++;
            return;
        }

        if (open < n) {
            backTrack(open + 1, close, n, res);
        }

        if (close < open) {
            backTrack(open, close + 1, n, res);
        }
    }

}
