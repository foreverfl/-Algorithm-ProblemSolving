L, P = map(int, input().split())
articles = list(map(int, input().split()))

cnt = L * P
for i in range(len(articles)):
    print(articles[i] - cnt, end=" ")
