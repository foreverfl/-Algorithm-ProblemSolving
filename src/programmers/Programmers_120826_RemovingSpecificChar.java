package programmers;

public class Programmers_120826_RemovingSpecificChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String my_string, String letter) {
		String answer = my_string.replaceAll(letter, "");
		return answer;
	}

}
