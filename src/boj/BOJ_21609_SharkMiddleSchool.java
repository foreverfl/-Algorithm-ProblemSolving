package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21609_SharkMiddleSchool {
	/*
	 * 1. 가장 큰 블록 찾기 (cluster 클래스). 우선순위는 사이즈 -> 무지개 블록 수 -> 행(가로) -> 열(세로)
	 * 2. 블록 제거하기 (-2로 변환)
	 * 3. 점수 계산하기 Math.pow(size, 2)
	 * 4. 중력 작용
	 * 5. 반시계 회전(임시 배열을 통한 복사 이용)
	 * 6. 중력 작용
	 * 7. 제일 큰 블록 크기가 1이면 끝내기
	 */
	private static class Cluster {
		int size;
		int rainbowBlock;
		int row;
		int column;

		public Cluster(int size, int rainbowBlock, int row, int column) {
			super();
			this.size = size;
			this.rainbowBlock = rainbowBlock;
			this.row = row;
			this.column = column;
		}

		public Cluster() {
			super();

		}

	}

	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static List<Cluster> clusters = new ArrayList<>();
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		map = new int[N][N];
		visited = new boolean[N][N];
		
	}

	private static void findLargestCluster() {
		Queue<Point> queue = new LinkedList<>();

	}
	
	private static void removeLargestCluster() {
		
	}
	
	private static void applyPowerOfRoh() {
		
	}
	
	private static void applyRotation() {
		
	}
}
