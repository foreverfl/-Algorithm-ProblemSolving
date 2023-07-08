from collections import Trie

# 트라이 객체 생성
trie = Trie()

# 단어 삽입
trie.insert("apple")
trie.insert("banana")
trie.insert("orange")

# 단어 검색
print(trie.search("apple"))  # True
print(trie.search("grape"))  # False

# 접두사 검색
print(trie.starts_with("app"))  # True
print(trie.starts_with("gr"))  # False
