package quanlydanhba.view;

import quanlydanhba.controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.showUserMenu();
    }
}
