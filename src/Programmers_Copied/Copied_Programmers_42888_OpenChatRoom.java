package Programmers_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Copied_Programmers_42888_OpenChatRoom {
	
	static int tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] arr = new String[T];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < tmp; i++) {
			System.out.println(solution(arr)[i]);
		}

	}

	public static String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<String, String>();
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			if (!str[0].equals("Leave"))
				map.put(str[1], str[2]);
		}

		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			if (str[0].equals("Enter")) {
				list.add(map.get(str[1]) + "님이 들어왔습니다.");
			} else if (str[0].equals("Leave")) {
				list.add(map.get(str[1]) + "님이 나갔습니다.");
			}
		}
		
		String[] answer = new String[list.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}

// reference: https://youjourney.tistory.com/69