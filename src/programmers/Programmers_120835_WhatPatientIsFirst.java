package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_120835_WhatPatientIsFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] emergency) {
		int size = emergency.length;
		List<Integer> list = new ArrayList<>();

		for (int num : emergency)
			list.add(num);

		Collections.sort(list, Collections.reverseOrder());

		int[] answer = new int[size];
		for (int i = 0; i < size; i++) {
			answer[i] = list.indexOf(emergency[i]) + 1;
		}
		return answer;
	}
}
