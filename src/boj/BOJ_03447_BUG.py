import re
import sys

input_lines = sys.stdin.readlines()

for line in input_lines:
    line = line.strip()
    while "BUG" in line:
        line = re.sub(r'BUG', '', line)
    print(line)
