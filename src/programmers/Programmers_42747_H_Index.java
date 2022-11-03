package programmers;

public class Programmers_42747_H_Index {

	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
		int ans = Integer.MIN_VALUE;

		for (int i = 0; i <= citations.length; i++) {
			int H = i;
			int cnt_more = 0;
			int cnt_less = 0;
			for (int j = 0; j < citations.length; j++) {
				if (citations[j] >= H)
					cnt_more++;
			}

			cnt_less = citations.length - cnt_more;
			if (cnt_more >= H && cnt_less < H)
				ans = Math.max(ans, H);

		}

		return ans = (ans == Integer.MIN_VALUE) ? 0 : ans;
	}

}
