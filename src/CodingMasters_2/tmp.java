package CodingMasters_2;

import java.util.HashMap;
import java.util.Map;

public class tmp {
    public static int countPossibleOriginalSentences(String[] words1, String[] words2) {
        Map<String, Integer> positions1 = new HashMap<>();
        Map<String, Integer> positions2 = new HashMap<>();

        // 각 단어의 위치를 저장
        for (int i = 0; i < words1.length; i++) {
            positions1.put(words1[i], i);
            positions2.put(words2[i], i);
        }

        // 교환 가능한 단어 쌍의 수를 찾기
        int swapsNeeded = 0;
        for (String word : words1) {
            if (positions1.get(word) != positions2.get(word)) {
                swapsNeeded++;
            }
        }

        // 실제로 교환되는 것은 쌍이므로, 총 교환 횟수는 절반
        swapsNeeded /= 2;

        // 교환 가능한 쌍이 없다면, 원래 문장은 하나뿐
        if (swapsNeeded == 0) {
            return 1;
        }

        // 교환 가능한 쌍이 있다면, 가능한 조합의 수 계산
        int combinations = 1;
        for (int i = 1; i <= swapsNeeded; i++) {
            combinations *= i;
        }

        return combinations;
    }

    public static void main(String[] args) {
        String[] sentence1 = { "buy", "our", "merch", "great", "sale" };
        String[] sentence2 = { "sale", "merch", "our", "great", "buy" };

        int possibleSentences = countPossibleOriginalSentences(sentence1, sentence2);
        System.out.println("Possible original sentences: " + possibleSentences);
    }
}
