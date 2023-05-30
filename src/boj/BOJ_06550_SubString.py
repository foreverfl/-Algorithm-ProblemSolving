while True:
    try:
        s, t = input().split()
    except EOFError:
        break

    idx = 0
    for i in range(len(t)):
        if idx == len(s):
            break
        if t[i] == s[idx]:
            idx += 1

    if (idx == len(s)):
        print("Yes")
    else:
        print("No")
