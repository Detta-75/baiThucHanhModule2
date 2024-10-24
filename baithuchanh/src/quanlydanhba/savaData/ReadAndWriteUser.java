package quanlydanhba.savaData;

import quanlydanhba.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteUser {
    private File file = new File("data/contacts.csv");
    public void WriteData(List<User> list) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            StringBuilder data = new StringBuilder();
            for (User user : list) {
                data.append(user.getSoDienThoai()).append(", ")
                        .append(user.getNhom()).append(", ")
                        .append(user.getHoTen()).append(", ")
                        .append(user.getGioiTinh()).append(", ")
                        .append(user.getDiaChi()).append(", ")
                        .append(user.getNgaySinh()).append(", ")
                        .append(user.getEmail()).append("\n");
            }

            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi vào tệp: " + e.getMessage());
        }
    }

    public List<User> ReadData() {
        List<User> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 4) {
                    User user = new User(data[0], data[1], data[2], data[3],data[4],data[5],data[6]);
                    list.add(user);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc từ tệp: " + e.getMessage());
        }
        return list;
    }
}
