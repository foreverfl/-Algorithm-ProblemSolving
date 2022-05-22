package BOJ_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_20920_MemorizingEnglishWordsIsPainful {

	static class Word implements Comparable<Word> {
		String word;
		int freq;

		Word(String word, int freq) {
			this.word = word;
			this.freq = freq;
		}

		@Override
		public int compareTo(Word o) {
			if (this.freq == o.freq) {

				if (o.word.length() == this.word.length()) {
					return this.word.compareTo(o.word);
				}
				return o.word.length() - this.word.length();
			} else
				return (o.freq - this.freq);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Word> map = new HashMap<>();
		
		List<String> wordSet = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.length() >= M) {
				if (map.containsKey(str)) {
					map.get(str).freq++;
				} else {
					map.put(str, new Word(str, 0));
					wordSet.add(str);
				}
			}
		}
		
		List<Word> ans = new ArrayList<>();
		for (int i = 0; i < wordSet.size(); i++) {
			ans.add(map.get(wordSet.get(i)));
		}
		
		Collections.sort(ans);
		
		for (int i = 0; i < ans.size(); i++) {
			bw.write(ans.get(i).word + "\n");
		}
		bw.flush();
		bw.close();

	}

}

// reference: https://velog.io/@pjh612/%EB%B0%B1%EC%A4%80-20920%EB%B2%88-%EC%98%81%EB%8B%A8%EC%96%B4-%EC%95%94%EA%B8%B0%EB%8A%94-%EA%B4%B4%EB%A1%9C%EC%9B%8C
