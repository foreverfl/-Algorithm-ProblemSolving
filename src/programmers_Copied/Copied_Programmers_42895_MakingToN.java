package programmers_Copied;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Copied_Programmers_42895_MakingToN {

	public static void main(String[] args) {
		System.out.println(solution(5, 12));
		System.out.println(solution(2, 11));
	}

	public static int solution(int N, int number) {
		List<Set<Integer>> countList = new ArrayList<>();

		for (int i = 0; i < 9; i++)
			countList.add(new HashSet<>());

		countList.get(1).add(N); // N을 1개 쓴 값은 N 혼자이다.

		for (int i = 2; i < 9; i++) {
			Set<Integer> countSet = countList.get(i);

			for (int j = 1; j <= i; j++) {
				Set<Integer> preSet = countList.get(j);
				Set<Integer> postSet = countList.get(i - j);
				System.out.println(j + " / " + (i - j));
				/* 
				 * (1 / 1), (2 / 0)
				 * (1 / 2), (2 / 1), (3 / 0)
				 * (1 / 3), (2 / 2), (3 / 1), (4 / 0)
				 * (1 / 4), (2 / 3), (3 / 2), (4 / 1), (5 / 0) 
				 * ...
				 */

				for (int preNum : preSet) {
					for (int postNum : postSet) {
						countSet.add(preNum + postNum);
						countSet.add(preNum - postNum);
						countSet.add(preNum * postNum);

						if (preNum != 0 && postNum != 0)
							countSet.add(preNum / postNum);
					}
				}
			}

			countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
		}

		for (Set<Integer> sub : countList) {
			if (sub.contains(number))
				return countList.indexOf(sub);
		}

		return -1;
	}
}
