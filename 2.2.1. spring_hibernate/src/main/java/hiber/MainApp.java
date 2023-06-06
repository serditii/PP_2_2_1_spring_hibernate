package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        Car car1 = new Car("Lada", 2101);
        user1.setUsCar(car1);
        userService.add(user1);
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        Car car2 = new Car("Nissan", 22);
        user2.setUsCar(car2);
        userService.add(user2);
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        Car car3 = new Car("Kia", 120);
        user3.setUsCar(car3);
        userService.add(user3);
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        Car car4 = new Car("Uaz", 3306);
        user4.setUsCar(car4);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Model = " + user.getCar().getModel());
            System.out.println("Series = " + user.getCar().getSeries());
        }
        User user = userService.userCar("Kia", 120);
        System.out.println("First Name = " + user.getFirstName());
        System.out.println("Last Name = " + user.getLastName());

        context.close();
    }
}
