package programmers;

public class Programmers_181892_FromN {
    public static int[] solution(int[] numList, int n) {
        int[] result = new int[numList.length - n + 1];
        
        int index = 0;        
        for (int i = n - 1; i < numList.length; i++) {
            result[index] = numList[i];
            index++;
        }
        
        return result;
    }
}
