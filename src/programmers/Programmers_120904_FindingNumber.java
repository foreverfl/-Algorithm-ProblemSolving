package programmers;

public class Programmers_120904_FindingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int num, int k) {
		String num_str = Integer.toString(num);
		String k_str = Integer.toString(k);

		if (num_str.contains(k_str)) {
			return num_str.indexOf(k_str) + 1;
		}
		return -1;
	}

}
