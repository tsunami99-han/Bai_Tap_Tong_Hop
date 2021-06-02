public class Student extends Person{
    private String className;

    public Student() {
    }

    public Student(String id, String firstName, String lastName,  int age, int gender, String address, String className) {
        super(id,  firstName, lastName, age, gender, address);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString()+
                ", className=" + className +
                '}';
    }
}