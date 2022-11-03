package programmers_Copied;

import java.util.Arrays;

public class Copied_Programmers_12941_MakingMinumumValue {

	public static void main(String[] args) {
		int[] A = { 1, 4, 2 };
		int[] B = { 5, 4, 4 };

		int result = solution(A, B);
		System.out.println(result);

	}

	public static int solution(int[] A, int[] B) {
		int sum = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		
		for (int i = 0; i < A.length; i++) {

			sum += A[i] * B[A.length - i - 1];

		}
		return sum;
	}

}

// reference: https://velog.io/@mkdevelop5002/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4%EC%B5%9C%EC%86%9F%EA%B0%92-%EB%A7%8C%EB%93%A4%EA%B8%B0with-JAVA