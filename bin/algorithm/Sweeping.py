# 스위프(sweep)라는 가상의 수직선 또는 수평선을 사용하여 공간을 효과적으로 탐색하는 방식
# 겹치는 선분의 개수를 세는 스위핑 알고리즘

def count_intersecting_segments(segments):
    events = []
    for start, end in segments:
        events.append((start, "start"))
        events.append((end, "end"))

    events.sort()  # 이벤트 리스트를 정렬

    count = 0
    intersecting = 0
    for point, event_type in events:
        if event_type == "start":
            intersecting += 1
        elif event_type == "end":
            intersecting -= 1
        count = max(count, intersecting)

    return count


segments = [(1, 4), (2, 5), (3, 6), (4, 7), (5, 8)]
result = count_intersecting_segments(segments)
print("Number of intersecting segments:", result)