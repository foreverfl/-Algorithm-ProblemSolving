from collections import deque

def bfs(grid, start):
    rows = len(grid)
    cols = len(grid[0])
    visited = [[False] * cols for _ in range(rows)]  # 방문 여부를 저장하는 2차원 배열
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]  # 상하좌우 방향

    queue = deque()
    queue.append(start)
    visited[start[0]][start[1]] = True

    while queue:
        node = queue.popleft()
        row, col = node

        # 해당 노드 처리 (예시에서는 출력)
        print(f"Visiting node: ({row}, {col})")

        # 인접한 노드들 확인
        for direction in directions:
            new_row = row + direction[0]
            new_col = col + direction[1]

            # 그리드 범위를 벗어나는 경우 무시
            if new_row < 0 or new_row >= rows or new_col < 0 or new_col >= cols:
                continue

            # 방문하지 않은 인접한 노드라면 큐에 추가하고 방문 표시
            if not visited[new_row][new_col]:
                queue.append((new_row, new_col))
                visited[new_row][new_col] = True


# 예시 2차원 그리드
grid = [
    [1, 0, 1, 1],
    [1, 1, 1, 0],
    [0, 0, 1, 1],
    [1, 1, 0, 1]
]

start_node = (0, 0)  # 시작 노드 좌표

bfs(grid, start_node)