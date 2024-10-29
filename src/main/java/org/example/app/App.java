package org.example.app;

import org.example.app.config.AppConfig;
import org.example.app.controller.EmployeeController;
import org.example.app.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        onEmployeeUtil(context);
        context.close();
    }

    public static void onEmployeeUtil(AnnotationConfigApplicationContext context) {
        EmployeeController employeeController =
                context.getBean("EmployeeController", EmployeeController.class);

        String employeeCreated1 =
                employeeController.create(new Employee("Alice", "Sales Manager", "+380 67 123 4567"));
        getOutput("\n>> Employee 1 created: " + employeeCreated1);
        String employeeCreated2 =
                employeeController.create(new Employee("Tom", "Software Developer", "+380 50 987 6543"));
        getOutput(">> Employee 2 created: " + employeeCreated2);
        String employeeCreated3 =
                employeeController.create(new Employee("Lucy", "System Administrator", "+380 44 555 1234"));
        getOutput(">> Employee 3 created: " + employeeCreated3);

        // Отримання всіх данних
        String employeeDataList = employeeController.getAll();
        getOutput("\n>> Employee data list:\n" + employeeDataList);

        System.out.print("\n>> Input Employee id to find Employee by id: ");
        Long employeeId = scanner.nextLong();
        String employeeById = employeeController.getById(employeeId);
        getOutput("\n>> Employee by id: " + employeeById);

        System.out.print("\n>> Input Employee id to update Employee by id: ");
        Long employeeToUpdateId = scanner.nextLong();
        Employee employeeToUpdate = new Employee();
        employeeToUpdate.setId(employeeToUpdateId);
        employeeToUpdate.setName("Lucy");
        employeeToUpdate.setPosition("Marketing Specialist");
        employeeToUpdate.setPhone("+380 63 222 7890");
        String employeeUpdated = employeeController.update(employeeToUpdate);
        getOutput("\n>> Employee updated: " + employeeUpdated);
        String employeeDataList2 = employeeController.getAll();
        getOutput("\n>> Employee data list 2:\n" + employeeDataList2);

        System.out.print("\n>> Input Employee id to delete Employee by id: ");
        Long employeeToDeleteId = scanner.nextLong();
        String employeeDeleteResult = employeeController.deleteById(employeeToDeleteId);
        getOutput("\n>> Delete Employee by id result: " + employeeDeleteResult);
        String employeeDataList3 = employeeController.getAll();
        getOutput("\n>> Employee data list 3:\n" + employeeDataList3);
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}
