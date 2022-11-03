package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02754_CalculatingGrade {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String grade = br.readLine();
		String toNumber = "";

		if (grade.equals("A+")) {
			toNumber = "4.3";
		} else if (grade.equals("A0")) {
			toNumber = "4.0";
		} else if (grade.equals("A-")) {
			toNumber = "3.7";
		} else if (grade.equals("B+")) {
			toNumber = "3.3";
		} else if (grade.equals("B0")) {
			toNumber = "3.0";
		} else if (grade.equals("B-")) {
			toNumber = "2.7";
		} else if (grade.equals("C+")) {
			toNumber = "2.3";
		} else if (grade.equals("C0")) {
			toNumber = "2.0";
		} else if (grade.equals("C-")) {
			toNumber = "1.7";
		} else if (grade.equals("D+")) {
			toNumber = "1.3";
		} else if (grade.equals("D0")) {
			toNumber = "1.0";
		} else if (grade.equals("D-")) {
			toNumber = "0.7";
		} else if (grade.equals("F")) {
			toNumber = "0.0";
		}
		
		System.out.println(toNumber);

	}

}
