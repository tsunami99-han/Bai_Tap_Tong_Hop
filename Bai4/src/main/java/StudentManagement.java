import java.util.*;

public class StudentManagement {
    private HashMap<String, Student> studentHashMap;
    Scanner sc = new Scanner(System.in);

    public StudentManagement() {
        studentHashMap = new HashMap<>();
    }

    public StudentManagement(HashMap<String, Student> studentHashMap) {
        this.studentHashMap = studentHashMap;
    }

    public HashMap<String, Student> getStudentHashMap() {
        return studentHashMap;
    }

    public String checkID(String id) {
        Set<String> keys = studentHashMap.keySet();
        for (String key : keys) {
            if (key == id) {
                return id;
            }
        }
        return null;
    }

    public void addNewStudent() {
        System.out.println("Enter ID:");
        String id = sc.nextLine();
        String result = checkID(id);
        while (result != null) {
            System.out.println("Error, re-enter ID");
            id = sc.nextLine();
        }
        System.out.println("FirstName is:");
        String firstName = sc.nextLine();
        System.out.println("LastName is:");
        String lastName = sc.nextLine();
        System.out.println("Age is:");
        int age = sc.nextInt();
        sc.nextLine();
        while (age <= 0) {
            System.out.println("Error, re-enter age:");
            age = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Gender is (1.Famale/2.Male):");
        int gender = sc.nextInt();
        sc.nextLine();
        while (gender != 0 && gender != 1) {
            System.out.println("Error, re-enter gender (1.Female/2.Male)");
            gender = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Address:");
        String address = sc.nextLine();
        System.out.println("ClassName is :");
        String className = sc.nextLine();
        Student student = new Student(id, firstName, lastName, age, gender, address, className);
        studentHashMap.put(id, student);
    }

    public void displayStudent() {
        Set<String> keys = studentHashMap.keySet();
        for (String key : keys) {
            System.out.println(studentHashMap.get(key).toString());
        }
    }

    public void deleteByID() {
        System.out.println("Enter ID:");
        String id = sc.nextLine();
        String result = checkID(id);
        if (result != null) {
            System.out.println("Deleted :" + studentHashMap.remove(result).toString());
        } else {
            System.out.println("No infomation was delete!");
        }
    }

    public Set checkName() {
        System.out.println("Enter firstname:");
        String firstname = sc.nextLine();
        System.out.println("Enter lastname:");
        String lastname = sc.nextLine();
        Set<String> keys = studentHashMap.keySet();
        Set<String> keyFind = new HashSet<>();
        if (lastname.equals("") && !firstname.equals("")) {
            for (String key : keys) {
                if (studentHashMap.get(key).getFirstName().equals(firstname)) {
                    keyFind.add(key);
                }
            }
            return keyFind;
        } else if (!lastname.equals("") && firstname.equals("")) {
            for (String key : keys) {
                if (studentHashMap.get(key).getLastName().equals(lastname)) {
                    keyFind.add(key);
                }
            }
            return keyFind;
        } else {
            for (String key : keys) {
                if (studentHashMap.get(key).getFirstName().equals(firstname) && studentHashMap.get(key).getLastName().equals(lastname)) {
                    keyFind.add(key);
                }
            }
            return keyFind;
        }
    }

    public void findByName() {
        Set<String> resuls = checkName();
        if (resuls.size() == 0) {
            System.out.println("No infomation!");
        } else {
            for (String key : resuls) {
                System.out.println(studentHashMap.get(key).toString());
            }
        }
    }

    public void findByID() {
        System.out.println("Enter ID:");
        String id = sc.nextLine();
        String result = checkID(id);
        if (result != null) {
            System.out.println("ID " + id + " is " + studentHashMap.get(result).toString());
        } else {
            System.out.println("No information!");
        }
    }

    public void editInformation(String id) {
        System.out.println("Enter new infomation or 0 if unchanged this option!");
        System.out.println("Firstname:");
        String firstName = sc.nextLine();
        if (firstName.equals("0")) {
            studentHashMap.get(id).setFirstName(studentHashMap.get(id).getFirstName());
        } else {
            studentHashMap.get(id).setFirstName(firstName);
        }
        System.out.println("Lastname:");
        String lastName = sc.nextLine();
        if (lastName.equals("0")) {
            studentHashMap.get(id).setLastName(studentHashMap.get(id).getLastName());
        } else {
            studentHashMap.get(id).setLastName(lastName);
        }
        System.out.println("New age:");
        int age = sc.nextInt();
        sc.nextLine();
        if (age > 0) {
            studentHashMap.get(id).setAge(age);
        } else {
            studentHashMap.get(id).setAge(studentHashMap.get(id).getAge());
        }
        System.out.println("Gender(1.Female/2.Male):");
        int gender = sc.nextInt();
        sc.nextLine();
        if (gender != 1 && gender != 2) {
            studentHashMap.get(id).setGender(studentHashMap.get(id).getGender());
        } else {
            studentHashMap.get(id).setGender(gender);
        }
        System.out.println("Enter address:");
        String address = sc.nextLine();
        if (address.equals(0)) {
            studentHashMap.get(id).setAddress(studentHashMap.get(id).getAddress());
        } else {
            studentHashMap.get(id).setAddress(address);
        }
        System.out.println("Classname is:");
        String className = sc.nextLine();
        if (className.equals("0")) {
            studentHashMap.get(id).setClassName(studentHashMap.get(id).getClassName());
        } else {
            studentHashMap.get(id).setClassName(className);
        }
    }

    public void editByID() {
        System.out.println("Enter ID");
        String id = sc.nextLine();
        String result = checkID(id);
        if (result == null) {
            System.out.println("Cant find this ID!");
        } else {
            editInformation(result);
        }
    }

    public void sortByName() {
        Set<Map.Entry<String, Student>> entries = studentHashMap.entrySet();
        List<Map.Entry<String, Student>> listEntries = new ArrayList<>(entries);
        Collections.sort(listEntries, new Comparator<Map.Entry<String, Student>>() {
            @Override
            public int compare(Map.Entry<String, Student> st1, Map.Entry<String, Student> st2) {
                if (st1.getValue().getLastName().equals(st2.getValue().getLastName())) {
                    return st1.getValue().getFirstName().compareTo(st2.getValue().getFirstName());
                } else {
                    return st1.getValue().getLastName().compareTo(st2.getValue().getLastName());
                }
            }
        });
        LinkedHashMap<String, Student> sortedstudentMap = new LinkedHashMap<>(listEntries.size());
        for (Map.Entry<String, Student> entry : listEntries) {
            sortedstudentMap.put(entry.getKey(), entry.getValue());
        }
        this.studentHashMap = sortedstudentMap;
    }

    public void sortByClass() {
        Set<Map.Entry<String, Student>> entries = studentHashMap.entrySet();
        List<Map.Entry<String, Student>> listEntries = new ArrayList<>(entries);
        Collections.sort(listEntries, new Comparator<Map.Entry<String, Student>>() {
            @Override
            public int compare(Map.Entry<String, Student> st1, Map.Entry<String, Student> st2) {
                return st1.getValue().getClassName().compareTo(st2.getValue().getClassName());
            }
        });
        LinkedHashMap<String, Student> sortedstudentMap = new LinkedHashMap<>(listEntries.size());
        for (Map.Entry<String, Student> entry : listEntries) {
            sortedstudentMap.put(entry.getKey(), entry.getValue());
        }
        this.studentHashMap = sortedstudentMap;
    }
}