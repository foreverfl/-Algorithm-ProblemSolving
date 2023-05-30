import sys

input = sys.stdin.readline

def make_set(n, start, end):
    if n == 0:
        return

    cnt = (end - start + 1) // 3  # 3등분
    # 왼쪽
    make_set(n - 1, start, start + cnt - 1)
    # 가운데
    for k in range(start + cnt, start + cnt * 2):
        answer[k] = ' '
    # 오른쪽
    make_set(n - 1, start + cnt * 2, start + cnt * 3 - 1)

while True:
    try:
        n = int(input())
        answer = ['-'] * (3 ** n)
        make_set(n, 0, 3 ** n - 1)
        print(''.join(answer))
    except:
        break

# reference: https://dalseoin.tistory.com/entry/%EB%B0%B1%EC%A4%80-%ED%8C%8C%EC%9D%B4%EC%8D%AC-4779-%EC%B9%B8%ED%86%A0%EC%96%B4-%EC%A7%91%ED%95%A9