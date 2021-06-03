import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int gender;
    private String address;
    private String email;
    private float avgPoint;

    public Student() {
    }

    public Student(String id, String firstName, String lastName, String dateOfBirth, int gender, String address, String email, float avgPoint) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.avgPoint = avgPoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(float avgPoint) {
        this.avgPoint = avgPoint;
    }

    @Override
    public String toString() {
        LocalDate date = LocalDate.now();
        int yearNow = Integer.parseInt(date.toString().substring(0, 4));
        int year = Integer.parseInt(dateOfBirth.substring(6));
        int age = yearNow - year;
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", avgPoint=" + avgPoint +
                '}';
    }
}
