package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Programmers_67258_JewelryShopping {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println(Arrays.toString(solution(new String[] {"AA", "AB", "AC", "AA", "AC"})));
        System.out.println(Arrays.toString(solution(new String[] {"XYZ", "XYZ", "XYZ"})));
        System.out.println(Arrays.toString(solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
    } 

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        for(String gem : gems) {
            set.add(gem);
        }
        
        Map<String, Integer> countMap = new HashMap<>(); // 현재 윈도우 내의 각 보석들의 개수들을 관리 
        int start = 0;
        int minLength = Integer.MAX_VALUE; // 가장 짧은 구간의 길이
        int minStart = 0; // 시작 인덱스
        int end = 0;

        while (start < gems.length) {
            if (countMap.size() == set.size()) {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                }

                countMap.put(gems[start], countMap.get(gems[start]) - 1);
                if (countMap.get(gems[start]) == 0) {
                    countMap.remove(gems[start]);
                }

                start++;
            } else {
                if (end == gems.length) {
                    break;
                }

                countMap.put(gems[end], countMap.getOrDefault(gems[end], 0) + 1);
                end++;
            }
        }

        answer[0] = minStart + 1;
        answer[1] = minStart + minLength;

        return answer;
    }
}