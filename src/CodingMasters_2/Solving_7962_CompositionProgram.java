package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solving_7962_CompositionProgram {
    public static final String[] chords = { "A", "B", "C", "D", "E", "F", "G", "Am", "Bm", "Cm", "Dm", "Em", "Fm",
            "Gm" };
    public static boolean[] used = new boolean[chords.length];
    public static Set<String> bannedProgressions = new HashSet<>();
    public static int count = 0;
    public static int maxConsecutive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        maxConsecutive = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            bannedProgressions.add(br.readLine());
        }

        backtrack(new ArrayList<>(), 0, 0);
        System.out.println(count);
    }

    public static void backtrack(List<String> progression, int consecutiveMajor, int consecutiveMinor) {
        if (progression.size() == 5) {
            count++;
            return;
        }

        for (int i = 0; i < chords.length; i++) {
            if (!used[i]) {
                String currentChord = chords[i];
                if (canUseChord(progression, currentChord, consecutiveMajor, consecutiveMinor)) {
                    used[i] = true;
                    progression.add(currentChord);

                    int nextConsecutiveMajor = isMajorOrMinor(currentChord).equals("major") ? consecutiveMajor + 1 : 0;
                    int nextConsecutiveMinor = isMajorOrMinor(currentChord).equals("minor") ? consecutiveMinor + 1 : 0;
                    backtrack(progression, nextConsecutiveMajor, nextConsecutiveMinor);

                    progression.remove(progression.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public static boolean canUseChord(List<String> progression, String chord, int consecutiveMajor,
            int consecutiveMinor) {
        if (progression.isEmpty()) {
            return true;
        }

        String lastChord = progression.get(progression.size() - 1);
        if (bannedProgressions.contains(lastChord + " " + chord)) {
            return false;
        }

        if (isMajorOrMinor(chord).equals("major") && consecutiveMajor >= maxConsecutive) {
            return false;
        }
        if (isMajorOrMinor(chord).equals("minor") && consecutiveMinor >= maxConsecutive) {
            return false;
        }

        return true;
    }

    public static String isMajorOrMinor(String chord) {
        return chord.endsWith("m") ? "minor" : "major";
    }
}
