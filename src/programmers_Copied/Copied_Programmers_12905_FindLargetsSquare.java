package programmers_Copied;

public class Copied_Programmers_12905_FindLargetsSquare {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } }));

	}

	public static int solution(int[][] board) {
		int answer = 0;
		int[][] newBoard = new int[board.length + 1][board[0].length + 1];
		// 새로운 배열 생성
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				newBoard[i + 1][j + 1] = board[i][j];

		int max = 0;

		// 만들 수 있는 정사각형 검사
		for (int i = 1; i < newBoard.length; i++) {
			for (int j = 1; j < newBoard[i].length; j++) {
				if (newBoard[i][j] == 1) {
					int left = newBoard[i - 1][j]; // 좌측 값
					int up = newBoard[i][j - 1]; // 상단 값
					int leftUp = newBoard[i - 1][j - 1]; // 좌측상단 값
					int min = Math.min(left, Math.min(up, leftUp));
					newBoard[i][j] = min + 1;
					max = Math.max(max, min + 1);
				}
			}
		}
		answer = max * max;
		return answer;
	}

}
