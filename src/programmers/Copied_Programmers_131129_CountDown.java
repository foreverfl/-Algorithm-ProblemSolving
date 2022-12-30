package programmers;

import java.util.Arrays;

public class Copied_Programmers_131129_CountDown {

	public static void main(String[] args) {
		int[] arr = solution(154);
		System.out.println(Arrays.toString(arr));
		arr = solution(58);
		System.out.println(Arrays.toString(arr));
	}

	private static final int MAX_TOTAL_SCORE_CAN_GET = 100000;
	private static final int BULL_SCORE = 50;
	private static final int MAX_SINGLE_SCORE = 20;
	private static final int MAX_SCORE_PER_DART = 60;
	private static final int IDX_NUM_OF_DART = 0;
	private static final int IDX_NUM_OF_SINGLE_OR_BULL = 1;

	private static int bestPlayToGetScoreList[][];

	public static int[] solution(int target) {
		int[] answer;

		initBestPlayToGetScoreList();

		for (int score = MAX_SINGLE_SCORE + 1; score <= target; score++) {

			if (score <= MAX_SCORE_PER_DART) {
				if (canGetScoreInOneDart(score) == false)
					findBestPlayToGetScore(score, score - 1);
			} else
				findBestPlayToGetScore(score, MAX_SCORE_PER_DART);
		}

		answer = bestPlayToGetScoreList[target];

		return answer;
	}

	private static void initBestPlayToGetScoreList() {

		bestPlayToGetScoreList = new int[MAX_TOTAL_SCORE_CAN_GET + 1][2];

		for (int score = 1; score <= MAX_SINGLE_SCORE; score++) {

			int doubleScore = score * 2;
			int tripleScore = score * 3;

			bestPlayToGetScoreList[score][IDX_NUM_OF_DART] = 1;
			bestPlayToGetScoreList[score][IDX_NUM_OF_SINGLE_OR_BULL] = 1;
			bestPlayToGetScoreList[doubleScore][IDX_NUM_OF_DART] = 1;
			bestPlayToGetScoreList[doubleScore][IDX_NUM_OF_SINGLE_OR_BULL] = 0;
			bestPlayToGetScoreList[tripleScore][IDX_NUM_OF_DART] = 1;
			bestPlayToGetScoreList[tripleScore][IDX_NUM_OF_SINGLE_OR_BULL] = 0;
		}

		bestPlayToGetScoreList[BULL_SCORE][IDX_NUM_OF_DART] = 1;
		bestPlayToGetScoreList[BULL_SCORE][IDX_NUM_OF_SINGLE_OR_BULL] = 1;

	}

	private static boolean canGetScoreInOneDart(final int score) {
		return bestPlayToGetScoreList[score][0] == 1;
	}

	private static void findBestPlayToGetScore(final int score, final int maxScoreToGet) {

		int minNumOfDart = score;
		int maxNumOfSingleOrBull = 0;

		for (int dartScore = 1; dartScore <= maxScoreToGet; dartScore++) {

			if (canGetScoreInOneDart(dartScore) == false)
				continue;

			int beforeScore = score - dartScore;
			int numOfDartToGetBeforeScore = bestPlayToGetScoreList[beforeScore][IDX_NUM_OF_DART];
			int numOfSingleOrBullToGetBeforeScore = bestPlayToGetScoreList[beforeScore][IDX_NUM_OF_SINGLE_OR_BULL];

			int unitOfDart = 1;
			boolean isSingleOrBull = (bestPlayToGetScoreList[dartScore][IDX_NUM_OF_SINGLE_OR_BULL] == 1) ? true : false;

			int expectedNumOfDart = numOfDartToGetBeforeScore + unitOfDart;
			int expectedNumOfSingleOrBull = numOfSingleOrBullToGetBeforeScore + ((isSingleOrBull == true) ? 1 : 0);

			if (expectedNumOfDart < minNumOfDart
					|| (expectedNumOfDart == minNumOfDart && expectedNumOfSingleOrBull > maxNumOfSingleOrBull)) {
				minNumOfDart = expectedNumOfDart;
				maxNumOfSingleOrBull = expectedNumOfSingleOrBull;
			}

		}

		bestPlayToGetScoreList[score][IDX_NUM_OF_DART] = minNumOfDart;
		bestPlayToGetScoreList[score][IDX_NUM_OF_SINGLE_OR_BULL] = maxNumOfSingleOrBull;

	}

}
