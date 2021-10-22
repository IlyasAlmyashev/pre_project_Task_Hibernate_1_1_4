package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Иван", "Петров", (byte) 25);
        System.out.println("User с именем – " + "Иван" + " добавлен в базу данных");
        userService.saveUser("Василий", "Иванов", (byte) 45);
        System.out.println("User с именем – " + "Василий" + " добавлен в базу данных");
        userService.saveUser("Александр", "Денисов", (byte) 52);
        System.out.println("User с именем – " + "Александр" + " добавлен в базу данных");
        userService.saveUser("Дмитрий", "Каменев", (byte) 28);
        System.out.println("User с именем – " + "Дмитрий" + " добавлен в базу данных");
        System.out.println();

        List<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);
        System.out.println();

        userService.removeUserById(1);
        userService.removeUserById(2);
        List<User> newAllUsers = userService.getAllUsers();
        newAllUsers.forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
