package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01434_OrganizingBooks {

	static int N, M, x, sum, box_sum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] box = new int[N];
		int[] book = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			book[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			while (true) {
				if (box[x] < book[i]) {
					x++;
				} else {
					box[x] -= book[i];
					break;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			sum += box[i];
		}

		System.out.println(sum);
	}
}

// refernce: https://fjdkslvn.tistory.com/25