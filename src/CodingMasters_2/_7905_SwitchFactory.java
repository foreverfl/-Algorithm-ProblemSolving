package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _7905_SwitchFactory {

    public static class Action {
        int time;
        char type;

        Action(int time, char type) {
            this.time = time;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Action> actions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            char type = input[1].charAt(0);
            actions.add(new Action(time, type));
        }

        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            int k = Integer.parseInt(br.readLine());

            boolean toggle = false;
            boolean hold = false;
            int lastToggleTime = 0;
            int lastHoldTime = 0;
            int toggleOnTime = 0;
            int holdOnTime = 0;

            for (Action action : actions) {
                if (action.time > k)
                    break;

                switch (action.type) {
                    case 'A':
                        toggle = !toggle;
                        if (toggle) {
                            lastToggleTime = action.time;
                        } else {
                            toggleOnTime += action.time - lastToggleTime;
                        }
                        break;
                    case 'C':
                        if (!hold) {
                            hold = true;
                            lastHoldTime = action.time;
                        }
                        break;
                    case 'D':
                        if (hold) {
                            hold = false;
                            holdOnTime += action.time - lastHoldTime;
                        }
                        break;
                }
            }

            if (toggle)
                toggleOnTime += k - lastToggleTime;
            if (hold)
                holdOnTime += k - lastHoldTime;

            sb.append(toggleOnTime + " " + holdOnTime).append('\n');
        }

        System.out.println(sb.toString().trim());
    }
}
