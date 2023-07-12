package programmers;

public class Programmers_181834_MakingTol {
    public String solution(String myString) {
        String answer = "";
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) <= 'l') {
                answer += 'l';
            } else {
                answer += myString.charAt(i);
            }
        }

        return answer;
    }
}
