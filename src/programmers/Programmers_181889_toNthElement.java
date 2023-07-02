package programmers;

public class Programmers_181889_toNthElement {
    public static int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = num_list[i];
        }
        return answer;
    }
}
