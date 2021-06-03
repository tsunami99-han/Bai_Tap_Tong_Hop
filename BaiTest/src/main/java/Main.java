import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void editingMenu() {
        System.out.println("Editing menu");
        System.out.println("1. Edit name");
        System.out.println("2. Edit birthday");
        System.out.println("3. Edit gender");
        System.out.println("4. Edit address");
        System.out.println("5. Edit email");
        System.out.println("6. Edit score");
        System.out.println("7. Edit whole information");
        System.out.println("0.Exit");
        System.out.print("Enter your option: ");
    }

    static void searchingMenu() {
        System.out.println("Searching menu");
        System.out.println("1. Search student by ID");
        System.out.println("2. Search student by name");
        System.out.println("3. Search student by age range");
        System.out.println("4. Search student by score range");
        System.out.print("Enter your option: ");
    }

    static void customerManagementMenu() {
        System.out.println("Student Management");
        System.out.println("1. Add student");
        System.out.println("2. Display Student list");
        System.out.println("3. Edit student by id");
        System.out.println("4. Delete student");
        System.out.println("5. Find student");
        System.out.println("6. Sort by avgPoint");
        System.out.println("7. Write to File");
        System.out.println("8. Read from File");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement(FileCSV.readByFileCSV("fileRead.csv"));
        do {
            int choice = -1;
            int option = -1;
            customerManagementMenu();
            int choice1 = studentManagement.checkInputType(choice);
            switch (choice1) {
                case 1:
                    studentManagement.addStudent();
                    break;
                case 2:
                    studentManagement.display();
                    break;
                case 3:
                    String id = sc.nextLine();
                    String result = studentManagement.checkID(id);
                    if (result == null) {
                        System.out.println("No information!");
                    } else {
                        do {
                            editingMenu();
                            int option1 = studentManagement.checkInputType(option);
                            switch (option1) {
                                case 1:
                                    studentManagement.editName(id);
                                    break;
                                case 2:
                                    studentManagement.editBirthDay(id);
                                    break;
                                case 3:
                                    studentManagement.editGender(id);
                                    break;
                                case 4:
                                    studentManagement.editAddress(id);
                                    break;
                                case 5:
                                    studentManagement.editEmail(id);
                                    break;
                                case 6:
                                    studentManagement.editAvgPoint(id);
                                    break;
                                case 7:
                                    studentManagement.editInformationByID(id);
                                    break;
                                case 0:
                                    System.exit(0);
                                default:
                                    System.out.println("Invalid!");
                            }
                        } while (true);
                    }
                    break;
                case 4:
                    studentManagement.deleteByID();
                    break;
                case 5:
                    searchingMenu();
                    int option1 = studentManagement.checkInputType(option);
                    switch (option1) {
                        case 1:
                            studentManagement.findByID();
                            break;
                        case 2:
                            studentManagement.findByName();
                            break;
                        case 3:
                        case 4:
                        default:
                            System.out.println("No choice!");
                    }
                    break;
                case 6:
                    studentManagement.sortByAvgPoint();
                    break;
                case 7:
                    FileCSV.writeToFileCSV("fileWrite.csv",studentManagement.getHashMap());
                    break;
                case 8:
                    System.out.println("Enter path");
                    String path= sc.nextLine();
                    FileCSV.readByFileCSV(path);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (true);
    }
}