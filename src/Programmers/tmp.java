package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tmp {
	public static void main(String[] args) {

		int[] stages_1 = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int N_1 = 5;
		int[] stages_2 = { 1, 2, 2, 1, 3 };
		int N_2 = 5;

		for (int i = 0; i < solution(N_1, stages_1).length; i++) {
			System.out.print(solution(N_1, stages_1)[i] + " ");
		}

		System.out.println();
		
		for (int i = 0; i < solution(N_2, stages_2).length; i++) {
			System.out.print(solution(N_2, stages_2)[i] + " ");
		}

	}

	  public static int[] solution(int N, int[] lastStages) {
	        int nPlayers = lastStages.length;
	        int[] nStagePlayers = new int[N + 2];
	        for (int stage : lastStages) {
	            nStagePlayers[stage] += 1;
	        }

	        int remainingPlayers = nPlayers;
	        List<Stage> stages = new ArrayList<>();
	        for (int id = 1 ; id <= N; id++) {
	            double failure = (double) nStagePlayers[id] / remainingPlayers;
	            remainingPlayers -= nStagePlayers[id];

	            Stage s = new Stage(id, failure);
	            stages.add(s);
	        }
	        Collections.sort(stages, Collections.reverseOrder());

	        int[] answer = new int[N];
	        for (int i = 0; i < N; i++) {
	            answer[i] = stages.get(i).id;
	        }
	        return answer;
	    }

	    static class Stage implements Comparable<Stage> {
	        public int id;
	        public double failure;

	        public Stage(int id_, double failure_) {
	            id = id_;
	            failure = failure_;
	        }

	        @Override
	        public int compareTo(Stage o) {
	            if (failure < o.failure ) {
	                return -1;
	            }
	            if (failure > o.failure ) {
	                return 1;
	            }
	            return 0;
	        }
	    }

}
