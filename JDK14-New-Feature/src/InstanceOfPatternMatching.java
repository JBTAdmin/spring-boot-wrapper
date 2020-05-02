// import java.util.Objects;
//
// public class InstanceOfPatternMatching {
//    public static void main(String[] args) {
//        Object obj = new Person(9);
//        Person person = null;//new Person(19);
//
//        if (obj.equals(person)) {
//            System.out.println("Objects are same");
//        } else {
//            System.out.println("Objects are diff");
//        }
//
//        // Pre JDK 14
//        if (obj instanceof Person) {
//            int age = ((Person) obj).getAge();
//            // use age to perform business logic
//        }
//
//        //JDK 14
//        if (obj instanceof Person person1){   //
//            int age = person1.getAge();
//            System.out.println("Age is " + age);
//        }
//        //System.out.println(person1.getAge());  person1 is not accessible here
//    }
// }
//
// class Person {
//    int age;
//
//    public Person(int age) {
//        this.age = age;
//    }
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(age);
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    //pre JDK 14
////    @Override
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (o == null || !(o instanceof Person)) return false;
////        Person person = (Person) o;
////        return age == person.age;
////    }
//
//    //JDK 14
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        return (o == null || (o instanceof Person person && person.getAge() == age));
//    }
// }
//
//
//// javac --enable-preview --release 14 InstanceOfPatternMatching.java
//// java --enable-preview InstanceOfPatternMatching
