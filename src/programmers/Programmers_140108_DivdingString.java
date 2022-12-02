package programmers;

public class Programmers_140108_DivdingString {

	public static void main(String[] args) {
		System.out.println(solution("aaaabbbbaa"));
		System.out.println(solution("banana"));
		System.out.println(solution("abracadabra"));
		System.out.println(solution("aaabbaccccabba"));
	}

	public static int solution(String s) {
		int answer = 0;
		char check = ' ';
		int same = 0;
		int diff = 0;

		for (int i = 0; i < s.length(); i++) {
			if (check == ' ') {
				check = s.charAt(i);
			}

			if (check == s.charAt(i)) {
				same++;
			} else {
				diff++;
			}

			if (same == diff) {
				answer++;
				check = ' ';
				same = 0;
				diff = 0;
			}

		}

		// 남아있는 글자 처리
		if (same != 0) {
			answer++;
		}
		
		// 모두 같은 글자라면
		return answer = (answer == 0) ? 1 : answer;
	}

}
