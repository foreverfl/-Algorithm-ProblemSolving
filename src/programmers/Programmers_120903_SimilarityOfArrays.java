package programmers;

public class Programmers_120903_SimilarityOfArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(String[] s1, String[] s2) {
		int answer = 0;
		for (String str1 : s1) {
			for (String str2 : s2) {
				if (str1.equals(str2))
					answer++;
			}
		}

		return answer;
	}

}
