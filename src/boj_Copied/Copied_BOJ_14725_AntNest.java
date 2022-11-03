package boj_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Copied_BOJ_14725_AntNest {

	static class TrieNode {

		Map<String, TrieNode> childNodes = new TreeMap<>();

		Map<String, TrieNode> getChildNodes() {
			return childNodes;
		}

	}

	static class Trie {

		TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		public void insert(String word, int[] arr) {

			TrieNode thisNode = rootNode;

			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				String str = word.substring(idx, idx + arr[i]);
				idx = idx + arr[i];

				thisNode = thisNode.getChildNodes().computeIfAbsent(str, key -> new TrieNode());
			}
		}

		public void print() {
			print(rootNode, 0);
		}

		public void print(TrieNode thisNode, int floor) {

			Set<String> set = thisNode.getChildNodes().keySet();
			Iterator<String> iterator = set.iterator();

			while (iterator.hasNext()) {
				String str = iterator.next();

				TrieNode childNode = thisNode.getChildNodes().get(str);
				for (int i = 0; i < floor; i++)
					System.out.print("--");
				System.out.println(str);
				print(childNode, floor + 1);

			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());

			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[K];

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < K; i++) {
				String str = st.nextToken();
				sb.append(str);
				arr[i] = str.length();
			}

			trie.insert(sb.toString(), arr);

		}

		trie.print();

	}

}

// reference: https://lotuslee.tistory.com/102
