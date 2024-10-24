package quanlydanhba.repository;

import quanlydanhba.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();

    void addUser(User user);

    void deleteUser(String soDienThoai);

    void updateUser(User user);

    User findByPhoneNumber(String soDienThoai);
}
