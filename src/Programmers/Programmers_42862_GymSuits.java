package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_42862_GymSuits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		List<Integer> lost_list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			lost_list.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		List<Integer> reserve_list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			reserve_list.add(Integer.parseInt(st.nextToken()));
		}

		int[] lost = lost_list.stream().mapToInt(i -> i).toArray();
		int[] reserve = reserve_list.stream().mapToInt(i -> i).toArray();

		int result = solution(N, lost, reserve);
		System.out.println(result);

	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		
		return answer;
	}
}
