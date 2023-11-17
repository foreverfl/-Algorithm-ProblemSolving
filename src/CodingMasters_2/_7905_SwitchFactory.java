package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7905_SwitchFactory {

    public static class Action {
        int time;
        char action;

        Action(int time, char action) {
            this.time = time;
            this.action = action;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Action[] action = new Action[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            action[i] = new Action(Integer.parseInt(input[0]), input[1].charAt(0));
        }

        int Q = Integer.parseInt(br.readLine());
        int[] questions = new int[Q];
        for (int i = 0; i < Q; i++) {
            questions[i] = Integer.parseInt(br.readLine());
        }

        int time = 0;
        // boolean isToggleOn = false;
        boolean isToggleOn = false;
        int toggleOnTime = 0;
        int holdOnTime = 0;

        StringBuilder sb = new StringBuilder();
        // A, B -> toggle
        // C, D -> hold
        int j = 0;
        for (int i = 0; i < N; i++) {
            time = action[i].time;

            if (action[i].action == 'A') { // 토글 스위치 누름
                isToggleOn = !isToggleOn;
                if (isToggleOn) {

                } else {

                }
            } else if (action[i].action == 'B') {
                isToggleOn = !isToggleOn;
                if (isToggleOn) {

                } else {

                }
            } else if (action[i].action == 'C') { // 홀드 스위치 누름
                holdOnTime = time - action[i].time;
            } else if (action[i].action == 'D') {
                holdOnTime = 0;
            }

            while (j < questions.length || time <= questions[j]) {
                int toggleActiveTime = questions[j] - toggleOnTime;
                int holdActiveTime = questions[j] - holdOnTime;
                sb.append(toggleActiveTime + " " + holdActiveTime).append('\n');

                if (time < questions[j]) {
                    break;
                }

                j++;
            }
        }

        System.out.println(sb.toString().trim());
    }
}
