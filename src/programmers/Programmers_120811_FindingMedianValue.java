package programmers;

import java.util.Arrays;

public class Programmers_120811_FindingMedianValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] array) {
		Arrays.sort(array);
		return array[array.length / 2];
	}
}
