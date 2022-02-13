package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01520_DownhillRoad {

<<<<<<< HEAD
	   private static int m,n;

	    private static int[][] map;
	    private static int[][] dp;

	    private static int[] dx = {-1, 0, 1, 0};
	    private static int[] dy = {0, 1, 0, -1};

	    public static void main(String[] args) throws IOException {

	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	        StringTokenizer st = new StringTokenizer(reader.readLine());

	        m = Integer.parseInt(st.nextToken());
	        n = Integer.parseInt(st.nextToken());

	        map = new int[m+1][n+1];
	        dp = new int[m+1][n+1];

	        for (int i=1; i<=m; i++) {
	            st = new StringTokenizer(reader.readLine());
	            for (int j=1; j<=n; j++) {
	                map[i][j] = Integer.parseInt(st.nextToken());
	                dp[i][j] = -1;
	            }
	        }

	        System.out.println(dfs(1,1));

	    }

	    private static int dfs(int x, int y) {

	        if (x == m && y == n) {
	            //도달했을때 추가탐색 필요 없다
	            return 1;
	        }
	        if (dp[x][y] != -1) {
	            //-1이 아닌 경우는 이미 방문했다(메모이제이션)
	            return dp[x][y];
	        } else {
	            //-1인 경우만 방문
	            dp[x][y] = 0;
	            for (int i=0; i<dx.length; i++) {
	                int nx = x + dx[i];
	                int ny = y + dy[i];

	                if (nx < 1 || ny < 1 || nx > m || ny > n) {
	                    continue;
	                }

	                if (map[x][y] > map[nx][ny]) {
	                    //현재 값이 더 큰 경우
	                    dp[x][y] += dfs(nx, ny);
	                }
	            }

	        }

	        return dp[x][y];
	    }//dfs
	}

=======
	static int[][] map, dp;
	static int[] dX = { 0, 0, -1, 1 };
	static int[] dY = { -1, 1, 0, 0 };
	static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));

	}

	private static int dfs(int x, int y) {
		if (x == M && y == N)
			return 1;

		if (dp[x][y] != -1)
			return dp[x][y];

		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nX = x + dX[i];
			int nY = y + dY[i];

			if (nX < 0 || nY < 0 || nX >= M || nY >= N)
				continue;
			if (map[nX][nY] < map[x][y]) {
				dp[x][y] += dfs(nX, nY);
			}
		}
		return dp[x][y];

	}

}
>>>>>>> refs/remotes/origin/master
