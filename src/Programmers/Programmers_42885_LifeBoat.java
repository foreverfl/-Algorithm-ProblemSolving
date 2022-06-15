package Programmers;

import java.util.Arrays;

public class Programmers_42885_LifeBoat {

	public static void main(String[] args) {
		int[] people_1 = { 70, 50, 80, 50 };
		int limit_1 = 100;
		int res_1 = solution(people_1, limit_1);
		System.out.println(res_1);

		int[] people_2 = { 70, 80, 50 };
		int limit_2 = 100;
		int res_2 = solution(people_2, limit_2);
		System.out.println(res_2);

	}

	public static int solution(int[] people, int limit) {

		Arrays.sort(people);

		int ans = 0;
		int min = 0;
		for (int max = people.length - 1; min <= max; max--) {
			if (people[min] + people[max] <= limit)
				min++;
			ans++;
		}

		return ans;
	}

}

// reference: https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java