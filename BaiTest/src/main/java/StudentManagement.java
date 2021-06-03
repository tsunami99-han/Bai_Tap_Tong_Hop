import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class StudentManagement {
    private HashMap<String, Student> hashMap;
    Scanner sc = new Scanner(System.in);

    public StudentManagement() {
        HashMap<String, Student> hashMap = new HashMap<>();
    }

    public StudentManagement(HashMap<String, Student> hashMap) {
        this.hashMap = hashMap;
    }

    public void display() {
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            System.out.println(hashMap.get(key).toString());
        }
    }

    public String checkID(String id) {
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            if (key.equals(id)) {
                return id;
            }
        }
        return null;
    }

    public Student creatStudent() {
        Student student;
        boolean check = false;
        String checkID = null;
        String id;
        String dateOfBirth;
        int gender = -1;
        String email;
        float avgpoint = -1;
//
        System.out.println("Enter ID:");
        id = validateData(Validation.ID_REGEX);
        System.out.println("Enter firstname :");
        String firstName = sc.nextLine();
        System.out.println("Enter lastname :");
        String lasttName = sc.nextLine();
//        do {
//            System.out.println("Dateofbirth :");
//            dateOfBirth = sc.nextLine();
//            check = Validation.validate(Validation.DATEOFBIRTH_REGEX, dateOfBirth);
//            if (check == false) {
//                System.err.println("Error,re-enter!");
//            }
//        } while (check == false);
        System.out.println("Enter dateofbirth: ");
        dateOfBirth = validateData(Validation.DATEOFBIRTH_REGEX);
        while (gender == -1) {
            try {
                do {
                    System.out.println("Enter gender(1.Female/2.Male/0.Other):");
                    gender = sc.nextInt();
                    if (gender != 1 && gender != 2 && gender != 0) {
                        System.out.println("Error,re-enter :");
                    }
                } while (gender != 1 && gender != 2 && gender != 0);
            } catch (InputMismatchException e) {
                System.err.println("Wrong type!");
            } finally {
                sc.nextLine();
            }
        }
        System.out.println("Enter address :");
        String address = sc.nextLine();
//        do {
//            System.out.println("Enter email: ");
//            email = sc.nextLine();
//            check = Validation.validate(Validation.EMAIL_REGEX, email);
//            if (check == false) {
//                System.err.println("Wrong regex!");
//            }
//        } while (check == false);
        System.out.println("Enter email :");
        email = validateData(Validation.EMAIL_REGEX);
        while (avgpoint == -1) {
            try {
                System.out.println("Enter avg point: ");
                avgpoint = sc.nextFloat();
            } catch (InputMismatchException e) {
                System.err.println("Wrong type!");
            } finally {
                sc.nextLine();
            }
        }
        student = new Student(id, firstName, lasttName, dateOfBirth, gender, address, email, avgpoint);
        return student;
    }

    public void addStudent() {
        Student st = creatStudent();
        hashMap.put(st.getId(), st);
    }

    public void addByFileCSV() throws IOException {
        System.out.println("Enter path:");
        String path = sc.nextLine();
        HashMap<String, Student> studentHashMap = FileCSV.readByFileCSV(path);
        hashMap.putAll(studentHashMap);
    }

    public Set checkName() {
        System.out.println("Enter firstname:");
        String firstname = sc.nextLine();
        System.out.println("Enter lastname:");
        String lastname = sc.nextLine();
        Set<String> keys = hashMap.keySet();
        Set<String> keyFind = new HashSet<>();
        if (lastname.equals("") && !firstname.equals("")) {
            for (String key : keys) {
                if (hashMap.get(key).getFirstName().equals(firstname)) {
                    keyFind.add(key);
                }
            }
            return keyFind;
        } else if (!lastname.equals("") && firstname.equals("")) {
            for (String key : keys) {
                if (hashMap.get(key).getLastName().equals(lastname)) {
                    keyFind.add(key);
                }
            }
            return keyFind;
        } else {
            for (String key : keys) {
                if (hashMap.get(key).getFirstName().equals(firstname) && hashMap.get(key).getLastName().equals(lastname)) {
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
                System.out.println(hashMap.get(key).toString());
            }
        }
    }

    public void findByID() {
        System.out.println("Enter ID:");
        String id = sc.nextLine();
        String result = checkID(id);
        if (result != null) {
            System.out.println("ID " + id + " is " + hashMap.get(result).toString());
        } else {
            System.out.println("No information!");
        }
    }

    public String validateData(String regex) {
        String string;
        boolean check = false;
        do {
            string = sc.nextLine();
            check = Validation.validate(regex, string);
            if (!check) {
                System.out.println("Wrong input, re input: ");
            }
        } while (!check);
        return string;
    }

    public void editName(String id) {
        System.out.print("Enter firstname: ");
        String firstName = sc.nextLine();
        if (!firstName.equals("")) {
            hashMap.get(id).setFirstName(firstName);
            System.out.println("Update successful!");
        } else {
            System.out.println("Update failed!");
        }
        System.out.print("Enter firstname: ");
        String lastName = sc.nextLine();
        if (!lastName.equals("")) {
            hashMap.get(id).setLastName(lastName);
            System.out.println("Update successful!");
        } else {
            System.out.println("Update failed!");
        }
//        FileCSV.writeToFileCSV("studentOutput.csv",hashMap);
    }

    public void editBirthDay(String id) {
        System.out.print("Enter birthday: ");
        String birthDay = validateData(Validation.DATEOFBIRTH_REGEX);
        if (!birthDay.equals("")) {
            hashMap.get(id).setDateOfBirth(birthDay);
            System.out.println("Update successful!");
        } else {
            System.out.println("Update failed!");
        }
    }

    public void editGender(String id) {
        System.out.print("Enter gender (1.Male/2.Female/0.Other): ");
        int gender = Integer.parseInt(validateData(Validation.GENDER_REGEX));
        hashMap.get(id).setGender(gender);
        System.out.println("Update successful!");
    }

    public void editAddress(String id) {
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        if (!address.equals("")) {
            hashMap.get(id).setAddress(address);
        }
    }

    public void editEmail(String id) {
        System.out.print("Enter email: ");
        String email = validateData(Validation.EMAIL_REGEX);
        if (!email.equals("")) {
            hashMap.get(id).setEmail(email);
            System.out.println("Update successful!");
        } else {
            System.out.println("Update failed!");
        }
    }

    public void editAvgPoint(String id) {
        float avgPoint = -1;
        System.out.print("Enter score: ");
        while (avgPoint == -1) {
            try {
                avgPoint = sc.nextFloat();
            } catch (InputMismatchException e) {
                System.err.println("Wrong type!");
            } finally {
                sc.nextLine();
            }
        }
        hashMap.get(id).setAvgPoint(avgPoint);
    }

    public void editInformationByID(String id) {
        String result = checkID(id);
        if (result == null) {
            System.err.println("No information!");
        } else {
            editName(id);
            editBirthDay(id);
            editGender(id);
            editAddress(id);
            editEmail(id);
            editAvgPoint(id);
        }
    }

    public void deleteByID() {
        System.out.println("Enter ID: ");
        String id = sc.nextLine();
        String result = checkID(id);
        if (result != null) {
            System.out.println("Do you want to delete :" + hashMap.get(result));
            System.out.println("Enter your choice(1.Yes/2.Other to cancle):");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                hashMap.remove(result);
            }
        } else {
            System.out.println("No infomation was delete!");
        }
    }

    public HashMap<String, Student> getHashMap() {
        return hashMap;
    }

    public void sortByAvgPoint() {
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        List<Map.Entry<String, Student>> listEntries = new ArrayList<>(entries);
        Collections.sort(listEntries, new Comparator<Map.Entry<String, Student>>() {
            @Override
            public int compare(Map.Entry<String, Student> st1, Map.Entry<String, Student> st2) {
                if (st1.getValue().getAvgPoint() > st2.getValue().getAvgPoint()) {
                    return 1;
                } else if (st1.getValue().getAvgPoint() < st2.getValue().getAvgPoint()) {
                    return -1;
                } else {
                    if (st1.getValue().getLastName().equals(st2.getValue().getLastName())) {
                        return st1.getValue().getFirstName().compareTo(st2.getValue().getFirstName());
                    } else {
                        return st1.getValue().getLastName().compareTo(st2.getValue().getLastName());
                    }
                }
            }
        });
        LinkedHashMap<String, Student> sortedstudentMap = new LinkedHashMap<>(listEntries.size());
        for (Map.Entry<String, Student> entry : listEntries) {
            sortedstudentMap.put(entry.getKey(), entry.getValue());
        }
        this.hashMap = sortedstudentMap;
    }
    public int checkInputType(int choice) {
        while (choice == -1) {
            try {
                choice = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Wrong type, re enter: ");
            } finally {
                sc.nextLine();
            }
        }
        return choice;
    }
}
