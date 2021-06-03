import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class FileCSV {
    static void writeToFileCSV(String path, HashMap<String, Student> hashMap){
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            String str = "";
            Set<String> keys = hashMap.keySet();
            String sex;
            for (String key : keys) {
                if (hashMap.get(key).getGender() == 1) {
                    sex = "Female";
                } else {
                    sex = "Male";
                }
                str += hashMap.get(key).getId() + "," + hashMap.get(key).getFirstName() + "," +
                        hashMap.get(key).getLastName() + "," + hashMap.get(key).getDateOfBirth() + "," +
                        sex + "," + hashMap.get(key).getAddress() + "," + hashMap.get(key).getEmail()+","+
                hashMap.get(key).getAvgPoint() + "\n";
            }
            bw.write(str);
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static HashMap<String, Student> readByFileCSV(String path){
        HashMap<String, Student> hashMap = new HashMap<>();
       try {
           FileReader fr = new FileReader(path);
           BufferedReader br = new BufferedReader(fr);
           String content;
           Student student;
           int gender;
           while ((content = br.readLine()) != null) {
               String[] obj = content.split(",");
               if (obj[4].equalsIgnoreCase("female")){
                   gender=1;
               }else if (obj[4].equalsIgnoreCase("male")){

                   gender=2;
               }else {
                   gender=0;
               }
               student = new Student(obj[0],obj[1],obj[2],obj[3],gender,obj[5],obj[6],Float.parseFloat(obj[7]));
               hashMap.put(obj[0],student);
           }
           br.close();
           fr.close();
       }catch (IOException e){
           System.err.println("Can't read file!");
       }
        return hashMap;
    }
}