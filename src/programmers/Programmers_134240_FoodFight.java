package programmers;

public class Programmers_134240_FoodFight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(int[] food) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < food.length; i++) {
			int repeat = food[i] / 2;
			while (repeat-- > 0) {
				sb.append(i);
			}
		}

		String answer = sb.toString() + 0 + sb.reverse().toString();
		return answer;
	}

}
