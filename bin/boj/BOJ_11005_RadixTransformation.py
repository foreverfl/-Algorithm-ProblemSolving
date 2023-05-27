def decimal_to_n_base(number, base):
    if number == 0:
        return '0'

    digits = []
    while number > 0:
        remainder = number % base
        remainder = number_to_alphabet(remainder)
        digits.append(str(remainder))
        number //= base

    return ''.join(digits[::-1])


def number_to_alphabet(number):
    if 0 <= number < 10:
        return str(number)
    elif 10 <= number < 36:
        return chr(ord('A') + number - 10)


N, B = map(int, input().split())
print(decimal_to_n_base(N, B))
