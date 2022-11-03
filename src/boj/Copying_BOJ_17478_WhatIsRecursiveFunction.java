package boj;

import java.util.Scanner;

public class Copying_BOJ_17478_WhatIsRecursiveFunction {

	static String underBar = "";
	static String sArr[];

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");

		sArr = new String[6];
		for (int i = 0; i < sArr.length; i++)
			sArr[i] = "";
		sArr[0] = "\"����Լ��� ������?\"";
		sArr[1] = "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.";
		sArr[2] = "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.";
		sArr[3] = "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"";
		sArr[4] = "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"";
		sArr[5] = "��� �亯�Ͽ���.";
		recursive(N);
	}

	public static void recursive(int num) {
		String temp = underBar;

		if (num == 0) {
			System.out.println(temp + sArr[0]);
			System.out.println(temp + sArr[4]);
			System.out.println(temp + sArr[5]);
			return;
		}

		for (int i = 0; i < 4; i++) // recursive statement
			System.out.println(temp + sArr[i]);

		underBar += "____"; // When called, the 'under bar' increase.
		
		recursive(num - 1);

		System.out.println(temp + sArr[5]); // "�亯�Ͽ���."
	}
}
