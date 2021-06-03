import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String,Student> map=FileCSV.readByFileCSV("D:\\02_Module2\\BT_Tuan3\\BaiTest\\src\\main\\fileRead.csv");
        System.out.println(map);
        FileCSV.writeToFileCSV("D:\\02_Module2\\BT_Tuan3\\BaiTest\\src\\main\\fileWrite.csv",map);
    }
}
