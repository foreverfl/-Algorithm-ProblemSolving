package programmers_Copied;

import java.util.HashMap;
import java.util.Map;

public class Copied_Programmers_64063_AssigningHotelRoom {
    public static long[] solution(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];
        Map<Long, Long> roomMap = new HashMap<>(); // key: 배정된 방 번호, value: 다음 빈 방 번호 
        
        for (int i = 0; i < len; i++) {
            long request = room_number[i];
            long allocatedRoom = findEmptyRoom(roomMap, request);
            answer[i] = allocatedRoom;
        }
        
        return answer;
    }
    
    private static long findEmptyRoom(Map<Long, Long> roomMap, long request) {
        if (!roomMap.containsKey(request)) {
            roomMap.put(request, request + 1);
            return request;
        }
        
        long nextRoom = findEmptyRoom(roomMap, roomMap.get(request));
        roomMap.put(request, nextRoom + 1);
        return nextRoom;
    }
}
