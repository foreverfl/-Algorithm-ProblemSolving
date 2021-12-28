package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class temp {

	public class Main {
	    public static int[] countAlphabet;
	    public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	        String word1 = br.readLine().trim();
	        String word2 = br.readLine().trim();

	        countAlphabet = new int[26];
	        int result = getAnagramCount(word1, word2);

	        bw.write(result);
	        bw.flush();
	        br.close();
	        bw.close();
	    }
	    public static int getAnagramCount(String word1, String word2){
	        int toBeRemovedCount = 0;
	        for(int index = 0; index<word1.length(); index++){
	            ++countAlphabet[word1.charAt(index)-97];
	        }

	        for(int index =0; index<word2.length();index++){
	            --countAlphabet[word2.charAt(index)-97];
	        }

	        for(int index = 0; index< countAlphabet.length; index++){
	            int count = Math.abs(countAlphabet[index]);
	            toBeRemovedCount += count;
	        }

	        return toBeRemovedCount;
	    }
	}

}
