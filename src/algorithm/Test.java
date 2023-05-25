package algorithm;

import java.io.*;
import java.util.*;
import java.math.*;

public class Test {
	public static void main(String[] args) {
		System.out.println("C#DEFGABC#DEFGAB".length());

	}

	public int[] solution(String[] keyinput, int[] board) {
		int[] now = { 0, 0 };
		for (int i = 0; i < keyinput.length; i++) {
			if (keyinput[i].equals("left"))
				now[0] -= now[0] > -(board[0] / 2) ? 1 : 0;
			else if (keyinput[i].equals("right"))
				now[0] += now[0] < (board[0] / 2) ? 1 : 0;
			else if (keyinput[i].equals("down"))
				now[1] -= now[1] > -(board[1] / 2) ? 1 : 0;
			else if (keyinput[i].equals("up"))
				now[1] += now[1] < (board[1] / 2) ? 1 : 0;
		}
		return now;
	}

}
