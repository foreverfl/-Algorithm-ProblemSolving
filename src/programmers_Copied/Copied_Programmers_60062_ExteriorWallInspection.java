package programmers_Copied;

public class Copied_Programmers_60062_ExteriorWallInspection {
    public static void main(String[] args) {
        System.out.println(solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
    }

    public static int solution(int n, int[] weak, int[] dist) {
        int[][] weak_cases = new int[weak.length][weak.length];
        int[] answer = {dist.length + 1};

        weak_cases = makeWeakCases(weak_cases, weak, n);
        makeDistCases(dist, weak_cases, new boolean[dist.length], new int[dist.length], 0, answer);
        if(answer[0] == dist.length + 1)
            return -1;
        else
            return answer[0];
    }

    public static int[][] makeWeakCases(int[][] weak_cases, int[] weak, int n) {
        int[] weak_case = weak.clone();
        weak_cases[0] = weak_case.clone();
        for (int i = 1; i < weak.length; i++) {
            int tmp = weak_case[0];
            for (int j = 1; j < weak.length; j++) {
                weak_case[j - 1] = weak_case[j];
            }
            weak_case[weak.length - 1] = tmp + n; // 배열의 마지막 값 갱신
            weak_cases[i] = weak_case.clone();
        }

        return weak_cases;
    }

    public static void makeDistCases(int[] dist, int[][] weak_cases, boolean[] dist_visit, int[] dist_case, int idx, int[] answer) {
        if (idx == dist.length) {
            for (int[] weak_case : weak_cases)
                check(dist_case, weak_case, answer);
        }
        for (int i = 0; i < dist.length; i++) {
            if (!dist_visit[i]) {
                dist_visit[i] = true;
                dist_case[idx] = dist[i];
                makeDistCases(dist, weak_cases, dist_visit, dist_case, idx + 1, answer);
                dist_visit[i] = false;
            }
        }
    }

    public static void check(int[] dist_case, int[] weak_case, int[] answer) {
        int cur = 0, next;
        int dist_idx = 0;
        while (cur < weak_case.length && dist_idx < dist_case.length) {
            next = cur + 1;
            while (next < weak_case.length && weak_case[cur] + dist_case[dist_idx] >= weak_case[next]) {
                next++;
            }
            cur = next;
            dist_idx++;
        }

        if (cur == weak_case.length && dist_idx < answer[0])
            answer[0] = dist_idx;
    }
}

// reference: https://dev-note-97.tistory.com/241