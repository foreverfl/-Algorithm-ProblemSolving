def solution(park, routes):
    my_map = [list(string) for string in park]

    pos = []
    for i in range(len(my_map)):
        for j in range(len(my_map[i])):
            if (my_map[i][j] == 'S'):
                pos = [i, j]

    for route in routes:
        dir, dis = route.split()
        if dir == 'E':
            new_x = pos[1] + int(dis)
            if new_x < len(my_map[0]) and all(my_map[pos[0]][c] in ['O', 'S'] for c in range(pos[1] + 1, new_x + 1)):
                pos[1] = new_x
        elif dir == 'W':
            new_x = pos[1] - int(dis)
            if new_x >= 0 and all(my_map[pos[0]][c] in ['O', 'S'] for c in range(new_x, pos[1])):
                pos[1] = new_x
        elif dir == 'S':
            new_y = pos[0] + int(dis)
            if new_y < len(my_map) and all(my_map[r][pos[1]] in ['O', 'S'] for r in range(pos[0] + 1, new_y + 1)):
                pos[0] = new_y
        elif dir == 'N':
            new_y = pos[0] - int(dis)
            if new_y >= 0 and all(my_map[r][pos[1]] in ['O', 'S'] for r in range(new_y, pos[0])):
                pos[0] = new_y

    return pos


solution(["SOO", "OOO", "OOO"], ["E 2", "S 2", "W 1"])
solution(["SOO", "OXX", "OOO"], ["E 2", "S 2", "W 1"])
solution(["OSO", "OOO", "OXO", "OOO"], ["E 2", "S 3", "W 1"])
