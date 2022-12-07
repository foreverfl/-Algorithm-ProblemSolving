package programmers_Copied;

import java.util.ArrayList;
import java.util.List;

public class Copied_Programmers_87390_CuttingArray {

	public static void main(String[] args) {
	}

	public List<Long> solution(int n, long left, long right) {

		List<Long> list = new ArrayList<>();

		for (long i = left; i < right + 1; i++) {
			list.add(Math.max(i / n, i % n) + 1);
		}

		return list;
	}
}
