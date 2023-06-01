import sys
input = sys.stdin.readline
N = int(input())
arr = [int(input()) for _ in range(N)]
arr.sort()

# x + y + z = k
arr_sum = set()  # x + y
for x in arr:
    for y in arr:
        arr_sum.add(x + y)


def check():
    global answer
    for i in range(N - 1, -1, -1):
        for j in range(i + 1):
            if arr[i] - arr[j] in arr_sum:  # k - z
                answer = arr[i]
                return


answer = 0
check()
print(answer)

# reference: https://2hs-rti.tistory.com/entry/%EB%B0%B1%EC%A4%80-2295%EB%B2%88-%EC%84%B8-%EC%88%98%EC%9D%98-%ED%95%A9-%ED%8C%8C%EC%9D%B4%EC%8D%AC
