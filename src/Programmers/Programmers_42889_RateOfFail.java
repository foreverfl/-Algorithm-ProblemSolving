package Programmers;

public class Programmers_42889_RateOfFail {

	public static void main(String[] args) {

		int[] stages_1 = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int N_1 = 5;
		int[] stages_2 = { 1, 2, 2, 1, 3 };
		int N_2 = 5;

//		for (int i = 0; i < solution(N_1, stages_1).length; i++) {
//			System.out.print(solution(N_1, stages_1)[i] + " ");
//		}
//
//		System.out.println();
		
		for (int i = 0; i < solution(N_2, stages_2).length; i++) {
			System.out.print(solution(N_2, stages_2)[i] + " ");
		}

	}

	public static int[] solution(int N, int[] stages) {
		double[] operation = new double[N];
		int[] answer = new int[N];

		for (int i = 1; i <= N; i++) {
			int numerator = 0;
			int denominator = 0;
			for (int j = 0; j < stages.length; j++) {
				if (stages[j] == i)
					numerator++;

				if (stages[j] >= i)
					denominator++;
			}
			operation[i - 1] = (double) numerator / denominator;
		}
		
		for(int i=0; i<operation.length; i++) {
			if(Double.isNaN(operation[i])) {
				operation[i] = 0;
			}
		}

		double max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < operation.length; j++) {
				if (operation[j] > max) {
					max = operation[j];
				}
			}
			for (int j = 0; j < operation.length; j++) {
				if (operation[j] == max) {
					answer[i] = j + 1;
					operation[j] = Integer.MIN_VALUE;
					break;
				}
			}
			max = Integer.MIN_VALUE;
		}

		return answer;
	}

}
