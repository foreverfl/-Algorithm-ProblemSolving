package programmers;

public class Programmers_120809_MakingArrayTwice {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(solution(new int[] { 1, 2, 100, -99, 1, 2, 3 }));

	}

	public static int[] solution(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] * 2;
		}

		return numbers;
	}

}
