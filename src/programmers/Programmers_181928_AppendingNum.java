package programmers;

public class Programmers_181928_AppendingNum {
    public static int solution(int[] num_list) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i : num_list) {
            if (i % 2 == 0) {
                even.append(i);
            } else {
                odd.append(i);
            }
        }

        int evenSum = Integer.parseInt(even.toString());
        int oddSum = Integer.parseInt(odd.toString());

        return evenSum + oddSum;
    }

    public static void main(String[] args) {
        int[] numList = {3, 4, 5, 2, 1};
        int result = solution(numList);
        System.out.println(result);
    }
}
