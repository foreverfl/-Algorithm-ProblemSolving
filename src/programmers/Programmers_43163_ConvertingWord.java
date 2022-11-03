package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_43163_ConvertingWord {

	public static void main(String[] args) {
		String begin_1 = "hit";
		String target_1 = "cog";
		String[] words_1 = { "hot", "dot", "dog", "lot", "log", "cog" };

		int res_1 = solution(begin_1, target_1, words_1);

		System.out.println(res_1);

		ans = 0;

		String begin_2 = "hit";
		String target_2 = "cog";
		String[] words_2 = { "hot", "dot", "dog", "lot", "log" };

		int res_2 = solution(begin_2, target_2, words_2);

		System.out.println(res_2);

	}

	static class Word {
		String str;
		int depth;

		Word(String str, int depth) {
			this.str = str;
			this.depth = depth;

		}
	}

	static int ans;
	static boolean[] visited;

	public static int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];

		bfs(begin, target, words);

		return ans;
	}

	public static void bfs(String begin, String target, String[] words) {
		Queue<Word> queue = new LinkedList<>();
		Word first = new Word(begin, 0);
		queue.offer(first);

		while (!queue.isEmpty()) {
			Word current = queue.poll();

			for (int i = 0; i < words.length; i++) {
				if (visited[i])
					continue;

				if (current.str.equals(target)) {
					ans = current.depth;
					return;
				}

				if (current.depth == words.length)
					return;

				if (isPossible(current.str, words[i])) {
					visited[i] = true;
					queue.offer(new Word(words[i], current.depth + 1));
					visited[i] = false;
				}
			}
		}
	}

	public static boolean isPossible(String str, String compared) {
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == compared.charAt(i))
				cnt++;
		}

		if (str.length() - 1 == cnt)
			return true;

		return false;

	}
}
