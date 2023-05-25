def find_smallest_linear_sequence(circular_sequence):
    n = len(circular_sequence)
    circular_sequence += circular_sequence
    smallest_sequence = circular_sequence[:n]

    for i in range(1, n):
        current_sequence = circular_sequence[i:i+n]
        if current_sequence < smallest_sequence:
            smallest_sequence = current_sequence

    return smallest_sequence


T = input()
for i in range(int(T)):
    sequence = input()
    print(find_smallest_linear_sequence(sequence))
