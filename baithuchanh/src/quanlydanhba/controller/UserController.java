package quanlydanhba.controller;

import quanlydanhba.model.User;
import quanlydanhba.service.IUserService;
import quanlydanhba.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private IUserService userService = new UserService();
    private Scanner scanner = new Scanner(System.in);

    public void display() {
        List<User> userList = userService.findAll();
        if (userList.isEmpty()) {
            System.out.println("Danh sach trong.");
        } else {
            System.out.println("Danh sach danh ba trong he thong: ");
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    public User inputData() {
        String soDienThoai;
        while (true) {
            System.out.println("Nhap so dien thoai: ");
            soDienThoai = scanner.nextLine();
            if (userService.findByPhoneNumber(soDienThoai) == null) {
                break;
            } else {
                System.out.println("So dien thoai da có tren he thong. Vui long nhap so dien thoai khac");
            }
        }
        System.out.println("Nhom cua danh ba: ");
        String nhom = scanner.nextLine();
        System.out.println("Nhap ten: ");
        String hoTen = scanner.nextLine();
        System.out.println("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        String diaChi = scanner.nextLine();
        System.out.println("Nhap ngay sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.println("Nhap email: ");
        String email = scanner.nextLine();
        User user = new User(soDienThoai, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email);
        System.out.println("Them moi thanh cong");
        return user;
    }

    public void updateUser() {
        System.out.println("Nhap so dien thoai: ");
        String soDienThoai = scanner.nextLine();
        User userUpdate = userService.findByPhoneNumber(soDienThoai);
        if (userUpdate == null) {
            System.out.println("Không tìm thấy trong hệ thống");
            return;
        }
        System.out.println("Nhom:");
        String newNhom = scanner.nextLine();
        if (!newNhom.isEmpty()) {
            userUpdate.setNhom(newNhom);
        }
        System.out.println("Ho Ten:");
        String newHoTen = scanner.nextLine();
        if (!newHoTen.isEmpty()) {
            userUpdate.setHoTen(newHoTen);
        }
        System.out.println("Gioi:");
        String newGioiTinh = scanner.nextLine();
        if (!newGioiTinh.isEmpty()) {
            userUpdate.setGioiTinh(newGioiTinh);
        }
        System.out.println("Dia Chi");
        String newDiaChi = scanner.nextLine();
        if (!newDiaChi.isEmpty()) {
            userUpdate.setDiaChi(newDiaChi);
        }
        System.out.println("Ngay sinh:");
        String newNgaySinh = scanner.nextLine();
        if (!newNgaySinh.isEmpty()) {
            userUpdate.setNgaySinh(newNgaySinh);
        }
        System.out.println("Email:");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            userUpdate.setEmail(newEmail);
        }
    }

    public void deleteUser() {
        System.out.println("Nhap so dien thoai: ");
        String remove = scanner.nextLine();
        int initialSize = userService.findAll().size();
        userService.deleteUser(remove);
        int newSize = userService.findAll().size();

        if (newSize < initialSize) {
            System.out.println("Xóa thành công.");
        } else {
            System.out.println("Không tìm thấy xe để xoá");
        }
    }

    public void displayUserDetails() {
        List<User> userList = userService.findAll();
        System.out.println("Nhap so ten can tim: ");
        String name = scanner.nextLine();
        User foundUser = null;
        for (User user: userList){
            if (user.getHoTen().equalsIgnoreCase(name)) {
                foundUser = user;
                break;
            }
        }
        if (foundUser != null) {
            System.out.println("Thong tin chi tiet:");
            System.out.println("1. So dien thoai " + foundUser.getSoDienThoai());
            System.out.println("2. Nhom: " + foundUser.getNhom());
            System.out.println("3. Ho ten: " + foundUser.getHoTen());
            System.out.println("4. Gioi tinh: " + foundUser.getGioiTinh());
            System.out.println("5. Dia chi: " + foundUser.getDiaChi());
            System.out.println("6. Ngay sinh: " + foundUser.getNgaySinh());
            System.out.println("7. email: " + foundUser.getEmail());
        } else {
            System.out.println("Khong tim thay");
        }
    }

    public void showUserMenu() {
        int i;
        do {
            System.out.println("====MENU====");
            System.out.println("1. Hien thi danh ba.");
            System.out.println("2. Them.");
            System.out.println("3. Cap nhat.");
            System.out.println("4. Xoa.");
            System.out.println("5. Tim kiem");
            System.out.println("0. Thoat.");
            System.out.println("==MOI CHON CHUC NANG==");
            i = Integer.parseInt(scanner.nextLine());
            switch (i) {
                case 1:
                    display();
                    break;
                case 2:
                    User user = inputData();
                    userService.addUser(user);
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    displayUserDetails();
                    break;
            }
        } while (i != 0);
    }
}
