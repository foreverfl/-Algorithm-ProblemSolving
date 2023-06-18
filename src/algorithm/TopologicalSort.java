package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public static List<Integer> topologicalSort(List<List<Integer>> graph, int numCourses) {
        int[] inDegree = new int[numCourses]; // 진입 차수 배열(정점으로 들어오는 간선의 수)
        for (List<Integer> edges : graph) {
            for (int course : edges) {
                inDegree[course]++;
            }
        }

        // 진입 차수가 0인 정점(어떤 다른 정점으로부터도 도달되지 않는 정점)들을 큐에 넣음
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);

            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 사이클 체크
        if (result.size() != numCourses) {
            return null; // 사이클이 존재하여 위상 정렬이 불가능
        }

        return result;
    }

    public static void main(String[] args) {
        int numCourses = 6; // 정점(과목)의 개수

        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프에 간선 추가
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(5);

        // 위상 정렬 수행
        List<Integer> result = topologicalSort(graph, numCourses);

        // 결과 출력
        if (result == null) {
            System.out.println("사이클이 존재하여 위상 정렬이 불가능합니다.");
        } else {
            System.out.println("위상 정렬 결과:");
            for (int course : result) {
                System.out.print(course + " ");
            }
        }
    }
}
