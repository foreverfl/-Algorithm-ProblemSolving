package programmers_Copied;

public class Copied_Programmers_12979_BaseStation {
    public static void main(String[] args) {
        System.out.println(solution(11, new int[] {4, 11}, 1));
        System.out.println(solution(16, new int[] {9}, 2));
    }

    public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int station_idx = 0;
		int position = 1;
		
		while (position <= n) {
			if (station_idx < stations.length && stations[station_idx] - w <= position) {
				position = stations[station_idx] + w + 1;
				station_idx++;
			} else {
				position += w * 2 + 1;
				answer++;
			}
		}
		
		return answer;
    }

}

// reference: https://honinbo-world.tistory.com/86