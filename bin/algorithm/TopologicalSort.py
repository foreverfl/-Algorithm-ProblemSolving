from collections import deque

def topological_sort(graph, numCourses):
    inDegree = [0] * numCourses  # 진입 차수 배열(정점으로 들어오는 간선의 수)
    for edges in graph:
        for course in edges:
            inDegree[course] += 1

    # 진입 차수가 0인 정점(어떤 다른 정점으로부터도 도달되지 않는 정점)들을 큐에 넣음
    queue = deque()
    for i in range(numCourses):
        if inDegree[i] == 0:
            queue.append(i)

    result = []
    while queue:
        course = queue.popleft()
        result.append(course)

        for nextCourse in graph[course]:
            inDegree[nextCourse] -= 1
            if inDegree[nextCourse] == 0:
                queue.append(nextCourse)

    # 사이클 체크
    if len(result) != numCourses:
        return None  # 사이클이 존재하여 위상 정렬이 불가능

    return result

# 정점(과목)의 개수
numCourses = 6

# 그래프 생성
graph = [[] for _ in range(numCourses)]

# 그래프에 간선 추가
graph[0].append(1)
graph[0].append(2)
graph[1].append(3)
graph[2].append(3)
graph[3].append(4)
graph[4].append(5)

# 위상 정렬 수행
result = topological_sort(graph, numCourses)

# 결과 출력
if result is None:
    print("사이클이 존재하여 위상 정렬이 불가능합니다.")
else:
    print("위상 정렬 결과:")
    for course in result:
        print(course, end=" ")