package com.student.main;

import com.student.services.StudentServices;

import java.util.Scanner;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 11/09/20 6:44 PM
 */
public class StudentMenu {

    private StudentServices studentServices = new StudentServices();

    public void initiateMainMenu(){
        System.out.println("<<< $$$ Welcome to Student Data Management System $$$ >>>");
        int choice = 0;
        while(choice != 5){
            System.out.println("What would you like to do?");
            System.out.println("1. Add new student");
            System.out.println("2. List all student");
            System.out.println("3. Retrieve a student record");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit");
            System.out.printf("Please input your choice here: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    studentServices.registerStudent();
                    break;
                }
                case 2:{
                    studentServices.listStudents();
                    break;
                }
                case 3: {
                    studentServices.retrieveStudent();
                    break;
                }
                case 4: {
                    studentServices.deleteStudent();
                    break;
                }
                case 5:{
                    System.out.println("Bye!");
                }
                default:{
                    System.out.println("Err! Invalid input.");
                    break;
                }
            }
        }
    }
}
