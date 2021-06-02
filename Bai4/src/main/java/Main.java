import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManagement studentManager=new StudentManagement();
        Scanner sc = new Scanner(System.in);
        HashMap<String,Student> map = null;
        try {
            map =FileCSV.readByFileCSV("D:\\02_Module2\\BT_Tuan3\\Bai4\\src\\main\\inputStudent.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(map);
        studentManager.getStudentHashMap().putAll((HashMap<String,Student>)map);
        studentManager.displayStudent();
//        System.out.println("StudentManagemena");
//        while (true){
//            System.out.println("Menu:");
//            System.out.println("1.Display.");
//            System.out.println("2.Add new student.");
//            System.out.println("3.Find by ID");
//            System.out.println("4.Find by name");
//            System.out.println("5.Delete by ID");
//            System.out.println("6.Edit by ID");
//            System.out.println("7.Sort by name");
//            System.out.println("8.Sort by class");
//            System.out.println("0.Exit");
//            System.out.println("Enter your choice:");
//            int choice=sc.nextInt();
//            switch (choice){
//                case 1:
//                    studentManager.displayStudent();
//                    break;
//                case 2:
//                    studentManager.addNewStudent();
//                    break;
//                case 3:
//                    studentManager.findByID();
//                    break;
//                case 4:
//                    studentManager.findByName();
//                    break;
//                case 5:
//                    studentManager.deleteByID();
//                    break;
//                case 6:
//                    studentManager.editByID();
//                    break;
//                case 7:
//                    studentManager.sortByName();
//                    break;
//                case 8:
//                    studentManager.sortByClass();
//                    break;
//                case 0:
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("No choice!");
//                    break;
//            }
//        }
    }
}