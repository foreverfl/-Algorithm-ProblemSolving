package programmers;

public class Programmers_17685_Autocomplete {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"go", "gone", "guild"}));
    }

    public static int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for(int i = 0; i < words.length; i++) {
            answer += trie.query(words[i]);
        }
        return answer;
    }

    static class Trie {
        boolean isleafNode = true; // 리프노드 여부
        Trie[] subTrie = new Trie[26];
    
        public void insert(String key) {
            int index = 0;
            Trie trie;
            if(this.subTrie[charToNumber(key.charAt(index))] == null) {
                trie = this.subTrie[charToNumber(key.charAt(index))] = new Trie();
            }else {
                trie = this.subTrie[charToNumber(key.charAt(index))];
                // 등록된적 있는 노드 이기 때문에 노드를 하나 더 추가하면서 리프노드가 아니게 됨
                trie.isleafNode = false;
            }
            index++;
        
            // 등록할 문자열을 순회하면서 하위 Trie를 생성 및 갱신
            while(index < key.length()) {
                int next = charToNumber(key.charAt(index));
                if(trie.subTrie[next] == null) {
                    trie.subTrie[next] = new Trie();
                }else {
                    trie.subTrie[next].isleafNode = false;
                }
                trie = trie.subTrie[next];
                index++;
            }
        }

        // 일치하는 접두사의 길이를 반환
        public int query(String key) {
            int sameCharCount = 1; // 일치하는 문자의 개수를 저장
            int index = 0;
            Trie trie = this.subTrie[charToNumber(key.charAt(index))];
            index++;
            while(index < key.length()) {
                int next = charToNumber(key.charAt(index));
                
                if(trie.isleafNode)
                    break;
                
                sameCharCount++;
                trie = trie.subTrie[next]; // 하위 트라이로 이동
                index++;
            }
            return sameCharCount;
        }

        public int charToNumber(char c) {
            return c - 'a';
        }
    }
}

// reference: https://wellbell.tistory.com/166