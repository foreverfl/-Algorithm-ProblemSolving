bar = input()
stack = []
res = 0

for i in range(len(bar)):
    if bar[i] == '(': # 쇠막대기의 개수를 증가시킴
        stack.append('(') 

    else:
        if bar[i - 1] == '(':  # 레이저
            stack.pop()
            res += len(stack)

        else:  # 쇠막대기의 끝
            stack.pop()
            res += 1

print(res)

# reference: https://inuplace.tistory.com/844