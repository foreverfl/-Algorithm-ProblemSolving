package programmers_Copied;

import java.util.ArrayList;
import java.util.List;

public class Copied_Programmers_60061_InstallationOfColumnsAndBeams {
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> answer = new ArrayList<>();
        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int stuff = build[2];
            int operation = build[3];
            
            if (operation == 1) { // 설치
                answer.add(new int[]{x, y, stuff});
                if (!check(answer)) {
                    answer.remove(answer.size() - 1);
                }
            } else if (operation == 0) { // 삭제
                int[] itemToRemove = null;
                for (int[] item : answer) {
                    if (item[0] == x && item[1] == y && item[2] == stuff) {
                        itemToRemove = item;
                        break;
                    }
                }
                if (itemToRemove != null) {
                    answer.remove(itemToRemove);
                    if (!check(answer)) {
                        answer.add(itemToRemove);
                    }
                }
            }
        }
        
        answer.sort((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int[][] result = new int[answer.size()][3];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }

    public boolean check(List<int[]> answer) {
        for (int[] item : answer) {
            int x = item[0];
            int y = item[1];
            int stuff = item[2];
            
            if (stuff == 0) { // 기둥(0) 체크
                // '바닥 위' or '보의 한쪽 끝 위' or '또 다른 기둥 위'
                if (y == 0 || contains(answer, x - 1, y, 1) || contains(answer, x, y, 1) || contains(answer, x, y - 1, 0)) {
                    continue;
                }
                return false;
            } else if (stuff == 1) { // 보(1) 체크
                // '한쪽 끝 부분이 기둥 위' or '양쪽 끝 부분이 다른 보와 연결'
                if (contains(answer, x, y - 1, 0) || contains(answer, x + 1, y - 1, 0) || (contains(answer, x - 1, y, 1) && contains(answer, x + 1, y, 1))) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    public boolean contains(List<int[]> answer, int x, int y, int stuff) {
        for (int[] item : answer) {
            if (item[0] == x && item[1] == y && item[2] == stuff) {
                return true;
            }
        }
        return false;
    }
}

// reference: https://blackon29.tistory.com/65