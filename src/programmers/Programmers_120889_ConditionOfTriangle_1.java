package programmers;

import java.util.Arrays;

public class Programmers_120889_ConditionOfTriangle_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] sides) {

		Arrays.sort(sides);

		if (sides[0] + sides[1] > sides[2])
			return 1;
		else
			return 2;
	}

}
