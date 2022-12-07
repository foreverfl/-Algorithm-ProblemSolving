package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_42586_DevelopingFunction {

	public static void main(String[] args) {
		int[] arr = solution(new int[] { 1, 1, 50 }, new int[] { 100, 2, 1 });
		System.out.println(Arrays.toString(arr));

	}

	private static class Function {
		int progress;
		int speed;

		public Function(int progress, int speed) {
			super();
			this.progress = progress;
			this.speed = speed;
		}

		@Override
		public String toString() {
			return "Function [progress=" + progress + ", speed=" + speed + "]";
		}

	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int size = progresses.length;
		List<Integer> list = new ArrayList<>();
		Queue<Function> queue = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			queue.add(new Function(progresses[i], speeds[i]));
		}

		while (!queue.isEmpty()) {
			int repeat = queue.size();
			while (repeat-- > 0) {
				Function now = queue.poll();
				now.progress += now.speed;
				queue.offer(now);
			}

			int cnt = 0;
			while (queue.peek().progress >= 100) {
				queue.poll();
				cnt++;

				if (queue.isEmpty()) {
					list.add(cnt);
					cnt = 0;
					break;
				}
			}

			if (cnt != 0) {
				list.add(cnt);
			}

		}

		int[] ans = new int[list.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = list.get(i);
		}

		return ans;
	}
}
