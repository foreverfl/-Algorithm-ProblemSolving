package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15979_FindingTeacher {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int gcd = calcGCD(Math.abs(A), Math.abs(B));

		if (A == 0 && B == 0)
			System.out.println(0);
		else if (gcd == 1)
			System.out.println(1);
		else
			System.out.println(2);
	}

	private static int calcGCD(int a, int b) {
		if (a == 0 || b == 0) {
			return a + b;
		}

		// 무조건 a가 큰 수여야 된다.
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		if (a % b == 0) {
			return b;
		}
		return calcGCD(b, a % b);
	}

}

// reference: https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=rdd573&logNo=221629173552