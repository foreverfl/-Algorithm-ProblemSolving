def merge_sort(A, p, r):
    if p < r:
        q = (p + r) // 2
        merge_sort(A, p, q)
        merge_sort(A, q + 1, r)
        merge(A, p, q, r)


def merge(A, p, q, r):
    global cnt, ans
    # p: 첫 번째 하위 배열의 시작 인덱스
    # q: 첫 번째 하위 배열의 끝 인덱스
    # r: 두 번째 하위 배열의 끝 인덱스

    i = p # 첫 번째 하위 배열의 현재 인덱스
    j = q + 1 # 두 번째 하위 배열의 현재 인덱스
    t = 0 # 임시 배열의 인덱스
    tmp = [0] * (r - p + 1)

    while i <= q and j <= r:
        if A[i] <= A[j]:
            tmp[t] = A[i]
            i += 1
        else:
            tmp[t] = A[j]
            j += 1
        t += 1

    while i <= q: # 왼쪽 배열 부분이 남은 경우
        tmp[t] = A[i]
        i += 1
        t += 1

    while j <= r: # 오른쪽 배열 부분이 남은 경우
        tmp[t] = A[j]
        j += 1
        t += 1

    i = p
    t = 0
    while i <= r: # 결과를 A[p..r]에 저장
        A[i] = tmp[t]
        cnt += 1
        if cnt == K:
            ans = A[i]
            break
        i += 1
        t += 1

N, K = map(int, input().split())
A = list(map(int, input().split()))
cnt = 0
ans = -1
merge_sort(A, 0, N - 1)
print(ans)