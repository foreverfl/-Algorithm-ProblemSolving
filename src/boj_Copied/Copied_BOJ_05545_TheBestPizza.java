package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Copied_BOJ_05545_TheBestPizza {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int topping_cnt = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int dough_price = Integer.parseInt(st.nextToken());
		int topping_price = Integer.parseInt(st.nextToken());

		int dough_kcal = Integer.parseInt(br.readLine());

		Integer[] topping_kcal_arr = new Integer[topping_cnt];
		for (int i = 0; i < topping_cnt; i++) {
			topping_kcal_arr[i] = Integer.parseInt(br.readLine());
		}

		int answer = dough_kcal / dough_price;

		Arrays.sort(topping_kcal_arr, Collections.reverseOrder());

		int tmp_price = dough_price;
		int tmp_kcal = dough_kcal;

		for (int i = 0; i < topping_cnt; i++) {
			tmp_price += topping_price;
			tmp_kcal += topping_kcal_arr[i];
			int tmp_answer = tmp_kcal / tmp_price;
			if (answer > tmp_answer)
				break;
			else
				answer = tmp_answer;

		}

		System.out.println(answer);

	}

}

// reference: https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-5545-%EC%B5%9C%EA%B3%A0%EC%9D%98-%ED%94%BC%EC%9E%90-Java
