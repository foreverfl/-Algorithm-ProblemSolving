minkuk = list(map(int, input().split()))
manse = list(map(int, input().split()))

S = sum(minkuk)
T = sum(manse)

print(max(S, T))
