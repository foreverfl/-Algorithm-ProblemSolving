package programmers;

public class tmp {

    public static class Student {
        String name;
        int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String... args) {
        Student student1 = new Student();
        Student sutdent2 = new Student("haruka", 18);
    }
}
