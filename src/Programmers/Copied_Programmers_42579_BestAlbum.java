package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Copied_Programmers_42579_BestAlbum {

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		int[] res = solution(genres, plays);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	static class Music {
		int num;
		String genres;
		int plays;

		Music(int num, String genres, int plays) {
			this.num = num;
			this.genres = genres;
			this.plays = plays;
		}
	}

	public static int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < plays.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}

		List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		List<Music> res = new ArrayList<>();

		for(Entry<String, Integer> entry : entries) {
			String now = entry.getKey();

			ArrayList<Music> list = new ArrayList<>();
			for (int i = 0; i < genres.length; i++) {
				if (genres[i].equals(now)) {
					list.add(new Music(i, now, plays[i]));
				}
			}

			Collections.sort(list, new Comparator<Music>() {

				@Override
				public int compare(Music o1, Music o2) {
					return o2.plays - o1.plays;
				}

			});
			res.add(list.get(0));
			if (list.size() != 1) {
				res.add(list.get(1));
			}

		}

		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i).num;
		}
		return ans;
	}

}

// https://velog.io/@yanghl98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%B2%A0%EC%8A%A4%ED%8A%B8%EC%95%A8%EB%B2%94-JAVA%EC%9E%90%EB%B0%94