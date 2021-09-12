package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _15552 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			String nums = br.readLine();
			String num[] = nums.split(" ");
			bw.write(Integer.parseInt(num[0]) + Integer.parseInt(num[1]) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
