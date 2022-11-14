package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_05984_TheBovineFireDrill {

	private static class Seat {
		int idx;
		int inner;
		int outer;

		public Seat() {
		}

		@Override
		public String toString() {
			return "Seat [idx=" + idx + ", inner=" + inner + ", outer=" + outer + "]";
		}

	}

	private static Seat[] arr;
	private static int[] moved;
	private static int N;
	private static int now = 1, movement, res;
	private static boolean isStart = true, isSame;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new Seat[N + 1];
		for (int i = 1; i <= N; i++) {
			Seat seat = new Seat();
			seat.idx = i; // 불변값
			seat.inner = i;
			seat.outer = -1;
			arr[i] = seat;
		}

		moved = new int[N + 1];

		while (true) {
			// 움직임 횟수 기록
			moved[now]++;

			isSame = false;
			res = now;
//			System.out.println(res);

			movement = arr[now].idx + now;
			if (movement > N) {
				movement = movement - N;
			}

			if (arr[now].idx == movement) {
				isSame = true;
			}

			// 어깨를 쳤는데 이미 움직인 소라면 break
			if (arr[movement].inner != -1 && moved[arr[movement].inner] >= 2) {
				break;
			}

			int tmp = arr[movement].inner;
			arr[movement].inner = now;
			arr[movement].outer = tmp;

			if (isStart) {
				arr[now].inner = -1;
				isStart = false;
			} else {
				if (!isSame) {
					arr[now].outer = -1;
				}
			}

			now = arr[movement].outer;

//			print();

			// 모든 자리가 차있다면 break
			if (isFull())
				break;
		}

		System.out.println(res);
	}

	private static boolean isFull() {
		boolean isEmpty = false;
		for (int i = 1; i <= N; i++) {
			if (arr[i].inner == -1) {
				isEmpty = true;
				break;
			}
		}

		if (!isEmpty)
			return true;

		return false;
	}

	private static void print() {
		for (int i = 1; i <= N; i++) {
			System.out.println(arr[i]);
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(moved[i] + " ");
		}
		System.out.println();
		System.out.println("===============");
	}

}
