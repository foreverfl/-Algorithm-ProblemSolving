count = 0

def fill_array(size, start_row, start_col):
    global count
    if size == 1:
        if start_row == r and start_col == c:
            print(count)
        return

    half = size // 2
    if r < start_row + half and c < start_col + half:
        fill_array(half, start_row, start_col)  # 왼쪽 상단 영역
    elif r < start_row + half and c >= start_col + half:
        count += half * half
        fill_array(half, start_row, start_col + half)  # 오른쪽 상단 영역
    elif r >= start_row + half and c < start_col + half:
        count += 2 * half * half
        fill_array(half, start_row + half, start_col)  # 왼쪽 하단 영역
    else:
        count += 3 * half * half
        fill_array(half, start_row + half, start_col + half)  # 오른쪽 하단 영역

N, r, c = map(int, input().split())
side = 2 ** N
fill_array(side, 0, 0)
