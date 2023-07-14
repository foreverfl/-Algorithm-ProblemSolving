package programmers_Copied;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_Programmers_150366_MergingTable {
    public static void main(String args[]) {
        System.out.println(Arrays.toString(solution(new String[] { "UPDATE 1 1 menu", "UPDATE 1 2 category",
                "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon",
                "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta",
                "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik",
                "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4" })));
    }

    public static int[] parent = new int[2501];
    public static String[] value = new String[2501];

    public static int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    // 좌표를 번호로 변환
    public static int convertNum(int x, int y) {
        int result = 50 * (x - 1);
        return result + y;
    }

    public static String[] solution(String[] commands) {
        // 초기화
        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
            value[i] = "";
        }

        // 명령어 실행
        List<String> result = new ArrayList<>();
        for (int ind = 0; ind < commands.length; ind++) {
            String line = commands[ind];
            StringTokenizer st = new StringTokenizer(line);
            String command = st.nextToken();

            if ("UPDATE".equals(command)) {
                // UPDATE value1 value2
                if (st.countTokens() == 2) {
                    String before = st.nextToken();
                    String after = st.nextToken();
                    for (int i = 1; i <= 2500; i++) {
                        if (before.equals(value[i]))
                            value[i] = after;
                    }
                }
                // UPDATE x y value
                else {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    String after = st.nextToken();
                    int num = convertNum(x, y);
                    value[find(num)] = after;
                }
            } else if ("MERGE".equals(command)) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int n1 = convertNum(x1, y1);
                int n2 = convertNum(x2, y2);
                int root1 = find(n1);
                int root2 = find(n2);

                if (root1 == root2)
                    continue;

                String rootString = value[root1].isBlank() ? value[root2] : value[root1];
                value[root1] = "";
                value[root2] = "";
                union(root1, root2);
                value[root1] = rootString;

            } else if ("UNMERGE".equals(command)) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = convertNum(x, y);
                int root = find(num);
                String rootString = value[root];
                value[root] = "";
                value[num] = rootString;
                List<Integer> deleteList = new ArrayList<>();
                for (int i = 1; i <= 2500; i++) {
                    if (find(i) == root)
                        deleteList.add(i);
                }
                for (Integer t : deleteList)
                    parent[t] = t;
            } else if ("PRINT".equals(command)) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = convertNum(x, y);
                int root = find(num);
                if (value[root].isBlank())
                    result.add("EMPTY");
                else
                    result.add(value[root]);
            }
        }
        return result.toArray(new String[0]);
    }
}

// reference: https://g-egg.tistory.com/105