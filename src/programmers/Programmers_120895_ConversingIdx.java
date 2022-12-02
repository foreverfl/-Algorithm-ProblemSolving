package programmers;

public class Programmers_120895_ConversingIdx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String my_string, int num1, int num2) {
		char A = my_string.charAt(num1);
		char B = my_string.charAt(num2);

		String ans = "";
		for (int i = 0; i < my_string.length(); i++) {
			if (i == num1) {
				ans += B;
			} else if (i == num2) {
				ans += A;
			} else {
				ans += my_string.charAt(i);
			}

		}
		return ans;
	}

}
