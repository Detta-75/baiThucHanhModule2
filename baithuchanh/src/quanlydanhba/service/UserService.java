package quanlydanhba.service;

import quanlydanhba.model.User;
import quanlydanhba.repository.IUserRepository;
import quanlydanhba.repository.UserRepository;
import quanlydanhba.savaData.ReadAndWriteUser;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private static List<User> userList = new ArrayList<>();
    private IUserRepository userRepository = new UserRepository();
    ReadAndWriteUser readAndWriteUser = new ReadAndWriteUser();

    @Override
    public List<User> findAll() {
        readAndWriteUser.ReadData();
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        readAndWriteUser.WriteData(userList);
        userRepository.addUser(user);
    }

    @Override
    public void deleteUser(String soDienThoai) {
        userRepository.deleteUser(soDienThoai);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public User findByPhoneNumber(String soDienThoai) {
        return userRepository.findByPhoneNumber(soDienThoai);
    }
}
