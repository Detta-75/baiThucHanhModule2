package quanlydanhba.repository;

import quanlydanhba.model.User;
import quanlydanhba.savaData.ReadAndWriteUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepository implements IUserRepository{
    private static List<User> userList = new ArrayList<>();
    ReadAndWriteUser readAndWriteUser = new ReadAndWriteUser();
    static {
        userList.add(new User("0979055577","1","Trần Văn A","Nam","190 Nguyễn Tất Thành","09/07/1999",""));
        userList.add(new User("0374595959","2","Nguyễn Thị B","Nữ","Hoàn Thi Loan","09/06/1999",""));
        userList.add(new User("0392707070","1","Lê Văn C","Nam","Nguyễn Tất Thành","09/05/1992",""));
    }
    @Override
    public List<User> findAll() {
        readAndWriteUser.ReadData();
        return userList;
    }

    @Override
    public void addUser(User user) {
        readAndWriteUser.WriteData(userList);
        userList.add(user);
    }

    @Override
    public void deleteUser(String soDienThoai) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getSoDienThoai().equalsIgnoreCase(soDienThoai)){
                userList.remove(i);
                break;
            }
        }
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getSoDienThoai().equalsIgnoreCase(user.getSoDienThoai())) {
                userList.set(i, user);
                break;
            }
        }
    }

    @Override
    public User findByPhoneNumber(String soDienThoai) {
        for (User user : userList) {
            if (user.getSoDienThoai().equals(soDienThoai)) {
                return user;
            }
        }
        return null;
    }

}
