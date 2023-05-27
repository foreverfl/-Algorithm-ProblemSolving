L = int(input())
A = int(input())
B = int(input())
C = int(input())
D = int(input())

math1, math2 = divmod(A, C)
if math2 != 0:
    math1 += 1

kor1, kor2 = divmod(B, D)
if kor2 != 0:
    kor1 += 1

homework = max(math1, kor1)
ans = L - homework
print(ans)
