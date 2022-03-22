package Programmers;

public class tmp {
	public static void main(String[] args) {
		int[][] map = new int[5][10];
		int idx = 1;
		for (int i = 0; i < 5; i++) { // yÃà
			for (int j = 0; j < 10; j++) { // xÃà 
				map[i][j] = idx;
				idx++;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%2d ", map[i][j]);
			}
			System.out.println();
		}
	}

}
