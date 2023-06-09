package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sweeping {
    
    public static class Segment {
        int start;
        int end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Event {
        int point;
        String eventType;

        Event(int point, String eventType) {
            this.point = point;
            this.eventType = eventType;
        }
    }

    public static void main(String[] args) {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(1, 4));
        segments.add(new Segment(2, 5));
        segments.add(new Segment(3, 6));
        segments.add(new Segment(4, 7));
        segments.add(new Segment(5, 8));

        int result = countIntersectingSegments(segments);
        System.out.println("Number of intersecting segments: " + result);
    }

    public static int countIntersectingSegments(List<Segment> segments) {
        List<Event> events = new ArrayList<>();
        for (Segment segment : segments) {
            events.add(new Event(segment.start, "start"));
            events.add(new Event(segment.end, "end"));
        }

        Collections.sort(events, Comparator.comparingInt(e -> e.point)); // 오름차순 정렬

        int count = 0;
        int intersecting = 0;
        for (Event event : events) {
            if (event.eventType.equals("start")) {
                intersecting++;
            } else if (event.eventType.equals("end")) {
                intersecting--;
            }
            count = Math.max(count, intersecting);
        }

        return count;
    }


}
