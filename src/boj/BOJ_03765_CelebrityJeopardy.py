while True:
    try:
        str = input()
    except EOFError:
        break

    print(str)
