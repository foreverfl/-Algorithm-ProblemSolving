package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7175_IQKing {

    static class Student implements Comparable<Student> {
        String name;
        int iq;

        public Student(String name, int iq) {
            this.name = name;
            this.iq = iq;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', iq=" + iq + '}';
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(o.iq, this.iq);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            students[i] = new Student(inputs[0], Integer.parseInt(inputs[1]));
        }

        Arrays.sort(students);
        Arrays.stream(students).limit(3).map(student -> student.name).forEach(System.out::println);
    }
}
