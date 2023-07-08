package programmers_Copied;

import java.util.Arrays;

public class Copied_Programmers_150367_BinaryTree {
    public static void main(String[] args) {
        long[] numbers = { 7, 42, 5 };
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }

	private static boolean dfs(String number) {
		boolean valid = true;
		
		int mid = (number.length() - 1) / 2;
		char root = number.charAt(mid);
		String left = number.substring(0, mid);
		String right = number.substring(mid + 1, number.length());
		
		if(root == '0' && (left.charAt((left.length() - 1) / 2) == '1' || right.charAt((right.length() - 1) / 2) == '1')){
			return false;
		}
		
		if(left.length() >= 3) {
			valid = dfs(left);
			if(valid) {
				valid = dfs(right);
			}
		}
		return valid;
	}

    public static int[] solution(long[] numbers) {
        int[] answer = new int [numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
        	String cur = Long.toBinaryString(numbers[i]);
        	int j = 0;
            
			/* 0번 레벨은 1개의 노드(루트), 1번 레벨은 2개의 노드, 2번 레벨은 2^2개의 노드를 가짐
			   cur 변수에 0을 추가해서 포화 이진트리를 만들 수 있는 이진수로 변환하는 과정
			 */
        	while((int) Math.pow(2, j) - 1 < cur.length()) {
        		j++;
        	}


        	while((int) Math.pow(2, j) - 1 != cur.length()) {
        		cur = "0" + cur;
        	}
		
        	if(dfs(cur)) {
        		answer[i] = 1;
        	}
        }
        return answer;
    }
}

// reference: https://velog.io/@seunghyun97/%ED%91%9C%ED%98%84-%EA%B0%80%EB%8A%A5%ED%95%9C-%EC%9D%B4%EC%A7%84%ED%8A%B8%EB%A6%AC