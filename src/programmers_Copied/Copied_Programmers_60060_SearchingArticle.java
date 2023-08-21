package programmers_Copied;

import java.util.Arrays;

public class Copied_Programmers_60060_SearchingArticle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[] { "frodo", "front", "frost", "frozen", "frame", "kakao" },
                        new String[] { "fro??", "????o", "fr???", "fro???", "pro?" })));
    }

    public static class TrieNode {
        private TrieNode[] children;
        private int count;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.count = 0; // 해당 노드를 마지막으로 하는 단어의 개수
        }

        public void insert(String word) {
            TrieNode node = this;
            for (char ch : word.toCharArray()) {
                node.count++;
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.count++;
        }

        public int search(String query) {
            TrieNode node = this;
            for (char ch : query.toCharArray()) {
                if (ch == '?') {
                    return node.count;
                }
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return 0;
                }
                node = node.children[index];
            }
            return node.count;
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        // 단어 길이별로 Trie 생성
        TrieNode[] forwardTries = new TrieNode[10001];
        TrieNode[] backwardTries = new TrieNode[10001];

        for (String word : words) {
            int length = word.length();
            if (forwardTries[length] == null) {
                forwardTries[length] = new TrieNode();
                backwardTries[length] = new TrieNode();
            }
            forwardTries[length].insert(word);
            backwardTries[length].insert(new StringBuilder(word).reverse().toString());
        }

        int idx = 0;
        for (String query : queries) {
            int count = 0;
            if (query.charAt(0) != '?') {
                if (forwardTries[query.length()] != null) {
                    count = forwardTries[query.length()].search(query);
                }
            } else {
                if (backwardTries[query.length()] != null) {
                    count = backwardTries[query.length()].search(new StringBuilder(query).reverse().toString());
                }
            }
            answer[idx++] = count;
        }

        return answer;
    }
}
