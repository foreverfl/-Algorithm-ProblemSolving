package programmers;

public class Programmers_250125_Neighbor {
    public int solution(String[][] board, int h, int w) {
        int max_h = board.length;
        int max_w = board[0].length;

        int ans = 0;
        String now = board[h][w];

        if (isValid(h + 1, w, max_h, max_w) && board[h + 1][w].equals(now))
            ans++;

        if (isValid(h, w + 1, max_h, max_w) && board[h][w + 1].equals(now))
            ans++;

        if (isValid(h - 1, w, max_h, max_w) && board[h - 1][w].equals(now))
            ans++;

        if (isValid(h, w - 1, max_h, max_w) && board[h][w - 1].equals(now))
            ans++;

        return ans;
    }

    public boolean isValid(int h, int w, int max_h, int max_w) {
        return w >= 0 && w < max_w && h >= 0 && h < max_h;
    }
}
